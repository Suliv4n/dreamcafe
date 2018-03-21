package com.sulivan.dreamcafe.samples.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.sulivan.dreamcafe.samples.command.CommandTest;
import com.sulivan.dreamcafe.system.command.CommandException;
import com.sulivan.dreamcafe.system.command.CommandManager;

public class CommandSample extends BasicGameState{

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		try {
			CommandManager.getInstance().register("test", CommandTest.class.getName());
			
		} catch (CommandException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame arg1, int arg2) throws SlickException {	
		
		if(container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			try {
				CommandManager.getInstance().run("test");
			} catch (CommandException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public int getID() {

		return 5;
	}

}
