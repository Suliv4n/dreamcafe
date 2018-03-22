package com.sulivan.dreamcafe.samples;



import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.sulivan.dreamcafe.samples.gamestates.CommandSample;
import com.sulivan.dreamcafe.samples.gamestates.DialogSample;
import com.sulivan.dreamcafe.samples.gamestates.EntitySample;
import com.sulivan.dreamcafe.samples.gamestates.PanelSample;
import com.sulivan.dreamcafe.samples.gamestates.TextSample;
import com.sulivan.dreamcafe.world.dungeon.DungeonBuilderOptions;
import com.sulivan.dreamcafe.world.dungeon.builder.RandomDungeonBuilder;




public class Main extends StateBasedGame{

	private static AppGameContainer container;
	private static StateBasedGame game;
	
	public Main(String name) {
		super(name);
	}

	
	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {

		game.addState(new PanelSample());
		game.addState(new TextSample());
		game.addState(new DialogSample());
		game.addState(new EntitySample());
		game.addState(new CommandSample());

		game.enterState(1);
		
		DungeonBuilderOptions options = new DungeonBuilderOptions();
		options.setOption("rooms.min_width", "10");
		options.setOption("rooms.max_width", "15");
		
		options.setOption("rooms.min_height", "10");
		options.setOption("rooms.max_height", "15");
		

		options.setOption("rooms.min_x_distance", "0");
		options.setOption("rooms.max_x_distance", "30");
		options.setOption("rooms.min_y_distance", "0");
		options.setOption("rooms.max_y_distance", "20");
		
		options.setOption("rooms.min_count", "3");
		options.setOption("rooms.max_count", "5");
		
		options.setOption("seed", "-2761134060183846889");
		
		RandomDungeonBuilder builder = new RandomDungeonBuilder();
		builder.configure(options);
		builder.build();
		
	}

	
	public static void main(String[] args) {

		game = new Main("Dreamship");
		
		try {
			container = new AppGameContainer(game);
			container.setDisplayMode(640, 320, false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}



}
