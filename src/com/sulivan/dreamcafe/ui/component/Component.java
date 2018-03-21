package com.sulivan.dreamcafe.ui.component;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.sulivan.dreamcafe.ui.Border;


/**
 * Renderable component that can be displayed in game.
 */
public abstract class Component {
	
	/**
	 * GameContainer which the component belongs to.
	 */
	private GameContainer container;
	
	/**
	 * Component coordinates.
	 */
	private float x;
	private float y;
	
	/**
	 * Dimensions of the component
	 */
	private float width;
	private float height;
	
	/**
	 * Component border.
	 */
	private Border border;
	
	/**
	 * Component background color.
	 */
	private Color backgroundColor;
	
	/**
	 * Construct a component.
	 *  
	 * @param container
	 * 	The GameContainer which the component belongs to.
	 */
	public Component(GameContainer container){
		this.container = container;
	}
	
	/**
	 * Construct a component with specified coordinates.
	 * 
	 * @param container
	 * 	The GameContainer which the component belongs to.
	 * @param x
	 * 	The abscissa of the component.
	 * @param y
	 * 	The ordinate of the component.
	 */
	public Component(GameContainer container, float x, float y){
		this.container = container;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Construct a component with specified coordinates.
	 * 
	 * @param container
	 * 	The GameContainer which the component belongs to.
	 * @param x
	 * 	The abscissa of the component.
	 * @param y
	 * 	The ordinate of the component.
	 * @param width
	 * 	The component width.
	 * @param height
	 * 	The component height.
	 */
	public Component(GameContainer container, float x, float y, float width, float height){
		this.container = container;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Return the container which the component belongs to.
	 * 
	 * @return the container which the component belongs to.
	 * 	
	 */
	public GameContainer getContainer(){
		return container;
	}
	
	/**
	 * Return the graphics context of the component.
	 * 
	 * @return the graphics context of the component.
	 */
	public Graphics getGraphics(){
		return container.getGraphics();
	}
	
	/**
	 * Set the coordinates where the component must be displayed in the Graphics context.
	 * 
	 * @param x
	 * 	abscissa of the component.
	 * @param y
	 * 	Ordinate of the Component.
	 */
	public void setXY(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Return the abscissa of the component.
	 * 
	 * @return
	 */
	public float getX(){
		return x;
	}
	
	/**
	 * Return the ordinate of the component.
	 * 
	 * @return
	 * 	the ordinate of the component.
	 */
	public float getY(){
		return y;
	}
	
	/**
	 * Set the dimensions of the component.
	 * 
	 * @param width
	 * 	The component width.	
	 * @param height
	 * 	The component heights.
	 */
	public void setDimensions(float width, float height){
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Set the component width.
	 * 
	 * @param width
	 *  The width of the component.
	 */
	public void setWidth(float width){
		this.width = width;
	}
	
	/**
	 * Set the component height.
	 * 
	 * @param height
	 *  The height of the component.
	 */
	public void setHeight(float height){
		this.height = height;
	}
	
	/**
	 * Get the component width.
	 * 
	 * @return the component width.
	 */
	public float getWidth(){
		return width;
	}
	
	/**
	 * Get the component height.
	 * 
	 * @return the component height.
	 */
	public float getHeight(){
		return height;
	}
	
	
	/**
	 * Set the component border.
	 * 
	 * @param border
	 * 	The component border.
	 */
	public void setBorder(Border border){
		this.border = border;
	}
	
	
	/**
	 * Return the component border.
	 * 
	 * @return
	 * 	The component border.
	 */
	public Border getBorder(){
		return border;
	}

	/**
	 * Return the component background color.
	 * 
	 * @return
	 * 	The panel color.
	 */
	public Color getBackgroundColor(){
		return backgroundColor;
	}
	
	/**
	 * Set the panel color.
	 * 
	 * @param color
	 * 	The panel color.
	 */
	public void setBackgroundColor(Color color){
		this.backgroundColor = color;
	}
	
	/**
	 * Render the border.
	 */
	public void renderBorder(){
		if(border != null){
			border.render(this);
		}
	}

	
	abstract void render();
}
