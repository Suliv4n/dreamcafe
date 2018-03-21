package com.sulivan.dreamcafe.ui.component;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.sulivan.dreamcafe.util.string.StringUtil;

/**
 * 
 * The component text allows to display text in the game window.
 */
public class Text extends Component{

	/**
	 * Text to display.
	 */
	private String text = "";
	
	/**
	 * The text color.
	 */
	private Color color;
	
	/**
	 * If the component will hide the overflowed text.
	 */
	private boolean hideOverflow = true;
	
	/**
	 * if true the component height will be adjusted to text height.
	 */
	private boolean autoHeight = false;
	
	
	/**
	 * Constructor.
	 * 
	 * @param container
	 * 	The container which the text component belong.
	 * @param text
	 * 	The text to display.
	 */
	public Text(GameContainer container, String text) {
		super(container);
		this.text = text;
	}
	
	/**
	 * Constructor with position coordinates.
	 * 
	 * @param container
	 * 	The container which the text component belong.
	 * @param text
	 * 	The text to display.
	 * @param x
	 * 	The abscissa where the text will be displayed. 
	 * @param y
	 * 	The ordinate where the text will be displayed.
	 */
	public Text(GameContainer container, String text, float x, float y) {
		super(container, x, y);
		this.text = text;
	}
	
	/**
	 * Constructor with position coordinates and dimensions.
	 * 
	 * @param container
	 * 	The container which the text component belong.
	 * @param text
	 * 	The text to display.
	 * @param x
	 * 	The abscissa where the text will be displayed. 
	 * @param y
	 * 	The ordinate where the text will be displayed.
	 * @param width
	 * 	The box width in which the text will be displayed.
	 * @param height
	 * 	The box height in which the text will be displayed.
	 */
	public Text(GameContainer container, String text, float x, float y, float width, float height) {
		super(container, x, y, width, height);
		this.text = text;
	}
	
	
	/**
	 * Constructor with position coordinates and dimensions.
	 * 
	 * @param container
	 * 	The container which the text component belong.
	 * @param text
	 * 	The text to display.
	 * @param x
	 * 	The abscissa where the text will be displayed. 
	 * @param y
	 * 	The ordinate where the text will be displayed.
	 * @param width
	 * 	The box height in which the text will be displayed.
	 * @param autoHeight
	 * 	Set to true if the box height have to be adjusted to text height.
	 */
	public Text(GameContainer container, String text, float x, float y, float width, boolean autoheight) {
		super(container, x, y, width, 0);
		this.text = text;
		this.autoHeight = true;
	}
	

	@Override
	public float getHeight(){
		
		if(!autoHeight){
			return super.getHeight();
		}

		float height = getTextFitingWidth().split("\r\n|\r|\n").length * getGraphics().getFont().getLineHeight();
		
		return  height;
	}

	@Override
	public void render(){
		
		Graphics g = getGraphics();
		
		
		float x = getX();
		float y = getY();
		float width = getWidth();
		float height = getHeight();
		
		if(getBorder() != null) {
			getBorder().render(this);
		}
		
		if(hideOverflow){
			g.setWorldClip(x, y, width, height);
		}
		
		Color current = g.getColor();
		
		if(color != null){
			g.setColor(color);
		}

		g.drawString(getTextFitingWidth(), x, y);
		
		g.setColor(current);
		
		if(hideOverflow){
			g.clearWorldClip();
		}
	}
	
	/**
	 * Set the text color.
	 * 
	 * @param color
	 * 	The text color.
	 */
	public void setColor(Color color){
		this.color = color;
	}
	
	/**
	 * Return the text color.
	 * 
	 * @return
	 * 	The text color.
	 */
	public Color getColor(){
		return color;
	}
	
	/**
	 * Set the text.
	 * 
	 * @param text
	 * 	The text.
	 */
	public void setText(String text){
		this.text = text;
	}
	
	/**
	 * Return the text.
	 * 
	 * @return the text.
	 */
	public String getText(){
		return text;
	}
	
	/**
	 * Set hiding on overflow
	 * 
	 * @param hide
	 * 	True if the text must be hide on overflow, else false
	 */
	public void setHideOverflow(boolean hide){
		hideOverflow = hide;
	}
	
	/**
	 * Return true if the overflowed text is hiding, else false.
	 * 
	 * @param true if the overflowed text is hiding, else false.
	 */
	public boolean getHideOverflow(boolean hide){
		return hideOverflow;
	}
	
	/**
	 * Return true if height is claculated, else false to fit the text height, else false.
	 * 
	 * @return true if the height is automatic else false.
	 */
	public boolean isAutoHeight(){
		return autoHeight;
	}
	
	
	/**
	 * Enable or disable the automatic height.
	 * 
	 * @param autoHeight
	 * 	True if the automatic must be enabled else false.
	 */
	public void setAutoHeight(boolean autoHeight){
		this.autoHeight = autoHeight;
	}
	
	
	/**
	 * The splited text with line breaks, so each line will be less long that the component width.
	 * 
	 * @return 
	 * 	Return a string less long than the component width.
	 */
	protected String getTextFitingWidth(){
		Graphics g = getGraphics();
		float width = getWidth();


		return StringUtil.getTextFitingWidth(g, width, text);
	}

}
