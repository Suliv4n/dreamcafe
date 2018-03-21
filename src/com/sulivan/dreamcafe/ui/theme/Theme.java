package com.sulivan.dreamcafe.ui.theme;

import java.util.HashMap;

import org.newdawn.slick.Color;

import com.sulivan.dreamcafe.ui.Border;
import com.sulivan.dreamcafe.ui.component.Component;
import com.sulivan.dreamcafe.util.color.ColorUtil;

public class Theme {

	HashMap<String, String> rules;
	
	public Theme(HashMap<String, String> rules){
		this.rules = rules;
	}
	
	public void apply(Component component) {
		setBorder(component);
		setBackground(component);
	}
	
	
	private void setBorder(Component component) {
		int borderWidth = getIntRule("component.border.width", 0);
		Color borderColor = getColorRule("component.border.color", null);
		Border border = new Border(borderColor, borderWidth);

		component.setBorder(border);
	}
	
	private void setBackground(Component component) {
		Color backgroundColor = getColorRule("component.background.color", null);
		
		if(backgroundColor != null) {
			component.setBackgroundColor(backgroundColor);
		}
		
	}
	
	
	public int getIntRule(String key, int defaultValue) {
		

		
		if(!rules.containsKey(key)) {
			return defaultValue;
		}

		return Integer.parseInt(rules.get(key));
	}
	
	public Color getColorRule(String key, Color defaultValue) {
		
		if(!rules.containsKey(key)) {
			return defaultValue;
		}
		
		return ColorUtil.parseColor(rules.get(key));
	}
	
	
	
	
}
