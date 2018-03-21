package com.sulivan.dreamcafe.util.color;

import org.newdawn.slick.Color;

public class ColorUtil {

	public static Color parseColor(String colorString){
		
		if(colorString.matches("^#[0-9a-fA-F]{3,6}$")) {
			if(colorString.length() == 4) {
				int colorValue = Integer.parseInt(colorString.substring(1), 16) * 4097;		
				return new Color(colorValue);
			}
			return Color.decode(colorString);
		}
		
		return parseFromName(colorString);
	}
	
	public static Color parseFromName(String name){
		
		String colorString = name.toLowerCase();
		
		for(ColorName colorName : ColorName.values()){
			if(colorName.name().equals(colorString)){
				System.out.println(colorName.getColor());
				return colorName.getColor();
			}
		}
		
		return null;
	}
	
}
