package com.sulivan.dreamcafe.util.string;

import org.newdawn.slick.Graphics;

public class StringUtil {
	
	
	/**
	 * Split the text in parameter into lines which render fit the width parameter.
	 * 
	 * @param g
	 * 	Graphics where the text is rendered.
	 * @param width
	 * 	The width the text must fit.
	 * @param text
	 * 	The text to split.
	 * @return The text that fit the width.
	 * 	
	 */
	public static String getTextFitingWidth(Graphics g, float width, String text){
		String[] paragraphs = text.split("\r\n|\r|\n");
		
		
		String textFitingWidth = "";
		
		for(String paragraph : paragraphs){

			String[] words = paragraph.split("\\s");
			String line = "";
			for(String word : words){
				if(g.getFont().getWidth(line + " " + word) < width){
					line = (line + " " + word).trim();
				}
				else{
					textFitingWidth += line+"\n";
					line = word;
				}
			}
			
			textFitingWidth += line + "\n";
		}

		return textFitingWidth.substring(0, textFitingWidth.length()-1);
	}

	
}
