package com.sulivan.dreamcafe.util.color;

import org.newdawn.slick.Color;

public enum ColorName {

	blue(Color.blue),
	red(Color.red),
	green(Color.green),
	yellow(Color.yellow),
	magenta(Color.magenta),
	pink(Color.pink),
	cyan(Color.cyan),
	orange(Color.orange),
	gray(Color.gray),
	lightgray(Color.lightGray),
	darkgray(Color.darkGray),
	white(Color.white),
	black(Color.black),
	transparent(Color.transparent);
	

	private Color color;
	
	ColorName(Color color) {
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}
	
	
}
