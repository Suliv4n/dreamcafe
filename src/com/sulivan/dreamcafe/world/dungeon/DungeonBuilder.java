package com.sulivan.dreamcafe.world.dungeon;

/**
 * A class representing which can generate dungeon map.
 * It must implement the building logic.
 */
public abstract class DungeonBuilder {

	/**
	 * Call before the build() method.
	 * It can overriding to read the DungeonBuilderOptions.
	 * 
	 * @param options
	 * 	Options for the building.
	 */
	public void configure(DungeonBuilderOptions options) {
		
	}

	/**
	 * Build the dungeon map.
	 * 
	 * @return the dungeon map built.
	 */
	abstract public DungeonMap build();

}
