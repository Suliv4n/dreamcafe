package com.sulivan.dreamcafe.ui.component;

import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.GameContainer;

/**
 * The dialog component is a Text component with some more features.
 * The text is splitting in subtext that fit the dialog dimensions, and allows you
 * to go to next or previous part.
 */
public class Dialog extends Text{
	
	private String completeText;
	
	private ArrayList<String> parts;
	private int currentIndex = 0;

	public Dialog(GameContainer container, String text) {
		super(container, text);
		completeText = text;
	}

	public Dialog(GameContainer container, String text, float x, float y) {
		super(container, text, x, y);
		completeText = text;
	}
	
	public Dialog(GameContainer container, String text, float x, float y, float width, float height) {
		super(container, text, x, y, width, height);
		completeText = text;
	}
	
	public Dialog(GameContainer container, String text, float x, float y, float width, boolean autoheight) {
		super(container, text, x, y, width, autoheight);
		completeText = text;
	}
	
	/**
	 * Initialize the dialog by splitting text into text parts that fit the dialog box.
	 */
	public void initialize() {
		setText(completeText);
		
		String[] lines = getTextFitingWidth().split("\n");
		
		parts = new ArrayList<String>();
		
		if(lines.length > 0) {
			int linesPerPart = (int) (double)Math.floor(getHeight() / (double)getGraphics().getFont().getLineHeight());
			int countParts = (int) Math.ceil((double)lines.length / (double)linesPerPart);

			for(int i=0; i<countParts; i++) {
				String[] partLines = Arrays.copyOfRange(lines, i * linesPerPart, Math.min((i+1) * linesPerPart, lines.length));
				String part = String.join("\n", partLines);
				parts.add(part);
			}
		}
		
		setText(parts.get(0));
		
		currentIndex = 0;
	}
	
	/**
	 * initialize() method must be called once before calling next() method.
	 * Set the current text to the next part of dialog.
	 * Do nothing if the current part is the last part.
	 * 
	 * @return
	 * 	False if the current part is the last, else true.
	 */
	public boolean next(){
		
		if(isLast()) {
			return false;
		}
		
		currentIndex++;
		
		updateText();
		return true;
	}
	
	/**
	 * initialize() method must be called once before calling previous() method.
	 * Set the current text to the previous part of dialog.
	 * Do nothing if the current part is the first part.
	 * 
	 * @return
	 * 	False if the current part is the first, else true.
	 */
	public boolean previous() {
		if(isFirst()) {
			return false;
		}
		
		currentIndex--;
		
		updateText();
		
		return true;
	}
	
	/**
	 * initialize() method must be called once before calling isFirst() method.
	 * Test if the current dialog part is the first part.
	 * 
	 * @return
	 * 	True if the current part is the first one, else false.
	 */
	public boolean isFirst() {
		return currentIndex == 0;
	}
	
	/**
	 * initialize() method must be called once before calling isLast() method.
	 * Test if the current dialog part is the last part.
	 * 
	 * @return
	 * 	True if the current part is the last one, else false.
	 */
	public boolean isLast() {
		return currentIndex == parts.size() - 1;
	}
	
	/**
	 * Replace the text by the text of the current text part.
	 */
	private void updateText() {
		setText(parts.get(currentIndex));
	}
	
}
