package com.sulivan.dreamcafe.world.dungeon.builder;


import java.util.Random;

import com.sulivan.dreamcafe.ui.random.RandomUtil;
import com.sulivan.dreamcafe.world.dungeon.DungeonBuilder;
import com.sulivan.dreamcafe.world.dungeon.DungeonBuilderOptions;
import com.sulivan.dreamcafe.world.dungeon.DungeonMap;

public class RandomDungeonBuilder extends DungeonBuilder{

	private int minimumRoomsXDistance;
	private int maximumRoomsXDistance;
	
	private int minimumRoomsYDistance;
	private int maximumRoomsYDistance;
	
	private int minimumRooms;
	private int maximumRooms;
	
	private int minimumRoomsWidth;
	private int minimumRoomsHeight;
	private int maximumRoomsWidth;
	private int maximumRoomsHeight;
	
	
	private long seed;
	
	public void configure(DungeonBuilderOptions options) {
		
		/*
		 * Number of rooms 
		 */
		minimumRooms = options.getIntOption("rooms.min_count", 1);
		maximumRooms = options.getIntOption("rooms.max_count", minimumRooms);
		
		/*
		 * Rooms dimensions 
		 */
		minimumRoomsWidth = options.getIntOption("rooms.min_width");
		maximumRoomsWidth = options.getIntOption("rooms.max_width");

		minimumRoomsHeight = options.getIntOption("rooms.min_height");
		maximumRoomsHeight = options.getIntOption("rooms.max_height");
		
		
		/*
		 * Gap between rooms 
		 */
		minimumRoomsXDistance = options.getIntOption("rooms.min_x_distance");
		maximumRoomsXDistance = options.getIntOption("rooms.max_x_distance");
		
		minimumRoomsYDistance = options.getIntOption("rooms.min_y_distance");
		maximumRoomsYDistance = options.getIntOption("rooms.max_y_distance");

		
		/*
		 * Optional preset seed 
		 */
		seed = options.getLongOption("seed", new Random().nextLong());
	}
	
	public DungeonMap build(){
		
		System.out.println("Building random dungeon with seed : " + seed);
		
		DungeonMap map = new DungeonMap();
		
		Random random = new Random(seed);
		
		int roomsCount = RandomUtil.randInt(random, minimumRooms, maximumRooms);
		
		int previousRoomX = -1;
		int previousRoomY = -1;
		
		int previousRoomWidth = -1;
		int previousRoomHeight = -1;
		
		for(int i=0; i<roomsCount; i++) {
			
			//first room is always at x=0;y=0 coordinates.
			int x = 0;
			int y = 0;
			
			//next rooms positions are calculated from their previous room position
			if(previousRoomX > -1) {
				x = previousRoomX;
				y = previousRoomY;

				x += RandomUtil.randInt(random, minimumRoomsXDistance, maximumRoomsXDistance);
				y += RandomUtil.randInt(random, minimumRoomsYDistance, maximumRoomsYDistance) * (random.nextBoolean() ? 1 : -1);
				
				//collides with the previous room
				if(	x >= previousRoomX - previousRoomWidth && 
					x <= previousRoomX + previousRoomWidth && 
					y >=  previousRoomY - previousRoomHeight &&
					y <= previousRoomY + previousRoomHeight) {
					
					//add x distance to avoid room collision
					x += 2 * previousRoomX + previousRoomWidth - x + 1;
				}
			}
			
			int width = RandomUtil.randInt(random, minimumRoomsWidth, maximumRoomsWidth);
			int height = RandomUtil.randInt(random, minimumRoomsHeight, maximumRoomsHeight);
			
			previousRoomWidth = width;
			previousRoomHeight = height;
			
			previousRoomX = x;
			previousRoomY = Math.max(y, 0);			
			
			
			map.fill(x, y, width, height, 'R');
		}
		
		map.debug();
		System.out.println("Width: " + map.getWidth() + " ; height: " + map.getHeight());

		return map;
	}
	
}
