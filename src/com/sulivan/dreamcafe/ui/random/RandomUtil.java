package com.sulivan.dreamcafe.ui.random;

import java.util.Random;

public class RandomUtil {
	
	public static int randInt(Random random, int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}
	
}
