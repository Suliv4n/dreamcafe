package com.sulivan.dreamcafe.samples.gamestates;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.sulivan.dreamcafe.ui.Border;
import com.sulivan.dreamcafe.ui.component.Panel;
import com.sulivan.dreamcafe.ui.theme.Theme;
import com.sulivan.dreamcafe.ui.theme.ThemeLoader;

public class PanelSample extends BasicGameState{

	private Panel panel;
	private Panel borderedPanel;
	private Panel themedPanel;

	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {

		panel = new Panel(container, 50, 50, 200, 60);
		panel.setBackgroundColor(Color.yellow);
		
		borderedPanel = new Panel(container, 0, 0, 300 ,20);
		borderedPanel.setBackgroundColor(Color.orange);
		borderedPanel.setBorder(new Border(Color.magenta, 3));
		
		themedPanel = new Panel(container, 30, 100, 100, 100);
		Theme theme = ThemeLoader.loadFromProperties("assets/theme/example.properties");
		theme.apply(themedPanel);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		panel.render();
		borderedPanel.render();
		themedPanel.render();
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if(container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			reloadTheme();
		}
	}

		

	private void reloadTheme() {
		Theme theme = ThemeLoader.loadFromProperties("assets/theme/example.properties");
		theme.apply(themedPanel);
	}

	@Override
	public int getID() {
		return 1;
	}

	
	
}
