package com.sulivan.dreamcafe.samples.gamestates;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.sulivan.dreamcafe.samples.entities.CharacterEntity;

public class EntitySample extends BasicGameState{

	private CharacterEntity character;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		
		SpriteSheet sprite = new SpriteSheet("assets/sample/character.png", 32, 32, Color.magenta);
		Animation animation = new Animation(sprite, 300);


		character = new CharacterEntity(container, animation);
		character.setXY(50, 50);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.fillRect(0, 0, 640, 320);
		character.render();
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
		
	}

	@Override
	public int getID() {
		return 3;
	}

}
