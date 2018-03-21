package com.sulivan.dreamcafe.world.dungeon;

import java.util.HashMap;

/**
 * Storage options for dungeon map building. 
 *
 */
public class DungeonBuilderOptions {

	/**
	 * Options : option key => option value
	 */
	private HashMap<String, String> options;

	/**
	 * Constructor.
	 */
	public DungeonBuilderOptions() {
		options = new HashMap<String, String>();
	}

	/**
	 * Set an option given by its key.
	 * 
	 * @param key
	 * 	The option key.
	 *
	 * @param value
	 * 	The option value
	 */
	public void setOption(String key, String value) {
		options.put(key, value);
	}

	/**
	 * Return an option value by its key.
	 * 
	 * @param key
	 * 	The option key.	
	 * @return
	 * 	The option value, null if key was not found.
	 */
	public String getOption(String key) {
		return getOption(key, null);
	}

	/**
	 * Return the option value given by its key or the default value.
	 * 
	 * @param key
	 * 	The option key.
	 * @param defaultValue
	 * 	The default value if the key was not found. 
	 * @return
	 * 	The option value or the default value if the key was not found.
	 */
	public String getOption(String key, String defaultValue) {

		if(options.containsKey(key)) {
			return options.get(key);
		}

		return defaultValue;
	}
	
	/**
	 * Return an int value of an option.
	 * 
	 * @param key
	 * 	The option key.
	 * @return
	 * 	The option int value or 0 if the key was not found.
	 */
	public int getIntOption(String key) {
		return getIntOption(key, 0);
	}
	
	/**
	 * Return an int value of an option or a default value if the key was not found.
	 * 
	 * @param key
	 * 	The option key.
	 * @param defaultValue
	 * 	The default value if the key was not found. 
	 * @return
	 * 	The option int value or the default value if the key was not found.
	 */
	public int getIntOption(String key, int defaultValue) {
		return Integer.parseInt(getOption(key, String.valueOf(defaultValue)));
	}
	
	/**
	 * Return a long value of an option.
	 * 
	 * @param key
	 * 	The option key.
	 * @return
	 * 	The option long value or 0 if the key was not found.
	 */
	public long getLongOption(String key) {
		return getLongOption(key, 0);
	}

	/**
	 * Return an long value of an option or a default value if the key was not found.
	 * 
	 * @param key
	 * 	The option key.
	 * @param defaultValue
	 * 	The default value if the key was not found. 
	 * @return
	 * 	The option long value or the default value if the key was not found.
	 */
	public long getLongOption(String key, long defaultValue) {
		return Long.parseLong(getOption(key, String.valueOf(defaultValue)));
	}
	
}