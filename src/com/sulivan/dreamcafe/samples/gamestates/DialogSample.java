package com.sulivan.dreamcafe.samples.gamestates;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.sulivan.dreamcafe.ui.Border;
import com.sulivan.dreamcafe.ui.component.Dialog;


public class DialogSample extends BasicGameState{


	private Dialog dialog;


	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		String text = "Hi ! This a sample of a dialog. A dialog is a text component with few more features.\nFor exemple the possibilty to go to the next lines.";
		dialog = new Dialog(container, text);
		dialog.setHeight(45);
		dialog.setWidth(638);
		dialog.setXY(1, 320-45-2);
		dialog.setBorder(new Border(Color.white, 1));
		
		dialog.initialize();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		if(dialog != null) {
			dialog.render();
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
		if(dialog != null) {
			if(container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				if(!dialog.next()) {
					dialog = null;
				}
			}
			else if(container.getInput().isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
				dialog.previous();
			}
		}
		
	}

	@Override
	public int getID() {
		return 4;
	}

}
