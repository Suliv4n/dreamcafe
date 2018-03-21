package com.sulivan.dreamcafe.ui.theme;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ThemeLoader {

	public static Theme loadFromProperties(String propertyFilepath) {
		
		Properties properties = new Properties();
		InputStream input = null;
		
		try {
			input = new FileInputStream(propertyFilepath);
			properties.load(input);
			
			HashMap<String, String> rules = new HashMap<String, String>();
			
			for(String propertyName : properties.stringPropertyNames()){
				rules.put(propertyName, properties.getProperty(propertyName));
			}
			
			return new Theme(rules);
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(input != null)
			{
				try {
					input.close();
				} 
				catch (IOException e) {}
			}
		}
		
		return null;
	}
	
}
