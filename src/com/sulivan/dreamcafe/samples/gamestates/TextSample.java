package com.sulivan.dreamcafe.samples.gamestates;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.sulivan.dreamcafe.ui.Border;
import com.sulivan.dreamcafe.ui.component.Text;

public class TextSample extends BasicGameState{

	private Text text;
	private Text longText;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {

		text = new Text(container, "Hello world !", 50, 50, 200, 60);
		text.setColor(Color.blue);
		text.setHideOverflow(false);
		
		longText = new Text(container, "This is a text that is longer than its container.\nAnd this an another phrase.", 100, 100, 100, true);
		longText.setColor(Color.red);
		longText.setBorder(new Border(Color.yellow));
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		text.render();
		longText.render();
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
	}

	@Override
	public int getID() {
		return 2;
	}

}
