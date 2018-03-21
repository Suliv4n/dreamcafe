package com.sulivan.dreamcafe.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import com.sulivan.dreamcafe.ui.component.Component;

/**
 * Border that can be used for components.
 * Represents a simple colored frame border.
 */
public class Border {

	private Color color;
	private int width = 1;
	
	/**
	 * Construct a border with a specific color.
	 * 
	 * @param color
	 * 	The border color.
	 */
	public Border(Color color){
		this.color = color;
	}
	
	/**
	 * Construct a border with a specific color and width.
	 * 
	 * @param color
	 * 	The border color.
	 * @param width
	 * 	The border width.
	 */
	public Border(Color color, int width){
		this.color = color;
		this.width = width;
	}
	
	/**
	 * Set the border width.
	 * 
	 * @param width
	 * 	The border width.
	 */
	public void setWidth(int width){
		this.width = width;
	}
	
	/**
	 * Display the border for a specific component.
	 * 
	 * @param component
	 * 	The component for which the border must be displayed.
	 */
	public void render(Component component){
		
		if(color != null){
			
			Graphics g = component.getGraphics();
			
			Color current = g.getColor();
			
			g.setColor(color);
			
			for(int i=0; i < width; i++){
				

				g.drawRect(
					component.getX() - i - 1, 
					component.getY() - i - 1, 
					component.getWidth() + i*2+1, 
					component.getHeight() + i*2+1
				);
				
			}
			
			g.setColor(current);
			
		}
		
	}
	
	
}
