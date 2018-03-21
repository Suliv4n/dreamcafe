package com.sulivan.dreamcafe.ui.component;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * A component to display a rectangle with optional borders and a optional background color.
 */
public class Panel extends Component {
	
	/**
	 * Constructor
	 * 
	 * @param container
	 * 	GameContainer containing the Panel.
	 * @param x
	 * 	The x position of the panel.
	 * @param y
	 * 	The y position of the panel.
	 * @param width
	 * 	The panel width.
	 * @param height
	 * 	The panel Height.
	 */
	public Panel(GameContainer container, float x, float y, float width , float height){
		super(container, x, y, width, height);
	}
	
	@Override
	public void render(){
		
		renderBorder();
		
		float width = getWidth();
		float height = getHeight();
		float x = getX();
		float y = getY();
		
		Graphics g = getGraphics();
		
		Color backgroundColor = super.getBackgroundColor();
		
		if(backgroundColor != null){
			Color current = g.getColor();
			g.setColor(backgroundColor);
			g.fillRect(x, y, width, height);	
			g.setColor(backgroundColor);
			g.setColor(current);
		}
	}

}
