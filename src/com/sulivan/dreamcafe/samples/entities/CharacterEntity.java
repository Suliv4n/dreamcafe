package com.sulivan.dreamcafe.samples.entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;

import com.sulivan.dreamcafe.entity.Entity;
import com.sulivan.dreamcafe.ui.component.Text;

public class CharacterEntity extends Entity{

	private Animation animation;
	private Text nameRenderer;
	private String name;
	
	public CharacterEntity(GameContainer container, Animation animation){
		super(container);
		this.animation = animation;
		
		name = "Suliv4n";
		nameRenderer = new Text(container, name);
		nameRenderer.setColor(Color.black);
		nameRenderer.setHideOverflow(false);
	}

	@Override
	public void render(){

		float x = getX();
		float y = getY();

		nameRenderer.setXY(x, y - nameRenderer.getHeight() - 40);
		nameRenderer.render();
		
		animation.draw(x, y);
	}

		
	
}
