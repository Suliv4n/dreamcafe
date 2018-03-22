package com.sulivan.dreamcafe.world.dungeon;

import java.util.ArrayList;

/*
 /!\ TEMPORARY CLASS. IT SHOULD BE RADICALLY CHANGED. /!\
 */

/**
 * A map of dungeon. 
 *	
 */
public class DungeonMap {

	private ArrayList<String> map;
	
	public DungeonMap(){
		map = new ArrayList<String>();
	}

	
	public int getWidth(){
		
		if(getHeight() == 0){
			return 0;
		}
		
		return map.get(0).length();
	}
	
	public int getHeight(){
		return map.size(); 
	}

	public void fill(int x, int y, int width, int height, char tile) {
		setMinHeight(y + height);
		setMinWidth(x + width);
		
		if(y<0){
			for(int i=0; i<-y-1; i++) {
				prependLine();
			}
			
			y=0;
		}
		
		
		for(int tileY = y; tileY < y+height; tileY++) {
			for(int tileX = x; tileX < x+width; tileX++) {

				setTile(tileX, tileY, tile);
			}
		}
		
	}
	
	public void setTile(int x, int y, char tile) {
		
		map.set(y, map.get(y).substring(0, x) + tile + map.get(y).substring(x+1));
	}
	
	public void setMinHeight(int height){
		
		int heightToAdd = height - getHeight();
		
		for(int i=0; i < heightToAdd; i++) {
			addLine();	
		}
	}
	
	public void setMinWidth(int width){

		int widthToAdd = width - getWidth();
		
		if(widthToAdd > 0) {
			
			for(int i=0; i<map.size(); i++) {
				map.set(i, map.get(i) + new String(new char[widthToAdd]).replace("\0", " "));
			}

		}

	}
	
	public void addLine() {
		map.add(new String(new char[getWidth()]).replace("\0", " "));
	}
	
	public void prependLine() {
		map.add(0, new String(new char[getWidth()]).replace("\0", " "));
	}
	
	public void prependColumn() {
		for(int i=0; i<map.size(); i++) {
			map.set(i, " " + map.get(i));
		}
	}

	public void debug() {
		
		
		System.out.print("+");
		
		for(int i=0; i<getWidth(); i++){
			System.out.print("-");
		}
		
		System.out.print("+");
		
		System.out.println();
		
		for(String line  : map){
			System.out.println("|" + line + "|");
		}
		
		System.out.print("+");
		
		for(int i=0; i<getWidth(); i++){
			System.out.print("-");
		}
		
		System.out.print("+");
		
		System.out.println();
	}


	public void border(int x, int y, int width, int height) {

		System.out.println(x);
		if(y<0){
			for(int i=0; i<-y; i++) {
				prependLine();
			}
			
			y=0;
		}
		
		if(x<0){
			for(int i=0; i<-x; i++) {
				prependColumn();
			}
			
			x=0;
		}
		
		setMinWidth(x + width + 1);
		setMinHeight(y + height + 1);

		
		setTile(x, y, '7');
		setTile(x + width, y, '9');
		setTile(x, y + height, '1');
		setTile(x + width, y + height, '3');

		for(int i=1; i<width; i++){
			setTile(x + i, y, '8');
			setTile(x + i, y + height, '2');
		}
		
		for(int i=1; i<height; i++){
			setTile(x, y + i, '4');
			setTile(x + width, y + i, '6');
		}

	}

}
