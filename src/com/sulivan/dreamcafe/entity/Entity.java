package com.sulivan.dreamcafe.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Shape;


/**
 * Represents a game entity.
 */
public abstract class Entity {
	
	/**
	 * Entity coordinates.
	 */
	private float x;
	private float y;
	
	private GameContainer container;
	
	private Shape hitbox;
	
	/**
	 * Construct an entity.
	 * 
	 * @param container
	 * 	The game container which the entity belongs to.
	 */
	public Entity(GameContainer container){
		this.container = container;
	}
	
	/**
	 * Return the entity hitbox.
	 * 
	 * @return the entity hitbox.
	 */
	public Shape getHitbox(){
		return hitbox;
	}
	
	
	/**
	 * Return the entity abscissa.
	 * 
	 * @return the entity abscissa.
	 */
	public float getX(){
		return x;
	}
	
	/**
	 * Return the entity ordinate.
	 * 
	 * @return the entity ordinate.
	 */
	public float getY(){
		return y;
	}
	
	/**
	 * Set the entity coordinates.
	 * 
	 * @param x
	 * 	The new entity abscissa.
	 * 
	 * @param y
	 * 	The new entity ordinate.
	 */
	public void setXY(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Set the entity abscissa.
	 * 
	 * @param x
	 * 	The new entity abscissa.
	 */
	public void setX(float x){
		this.x = x;
	}
	
	/**
	 * Set the entity ordinate.
	 * 
	 * @param x
	 * 	The new entity ordinate.
	 */
	public void setY(float y){
		this.y = y;
	}
	
	
	/**
	 * Return the game container which the entity belongs to.
	 * 
	 * @return the game container which the entity belongs to.
	 */
	public GameContainer getContainer(){
		return container;
	}
	
	public abstract void render();
}
