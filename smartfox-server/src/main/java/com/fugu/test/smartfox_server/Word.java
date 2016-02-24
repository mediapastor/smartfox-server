package com.fugu.test.smartfox_server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Word {

	private static Random randomGenerator;
	private static List<String> words;
	
	public static String getNewWord() {
		
		words = new ArrayList<>();
		
		String[] values = {"cat", "dog", "game", "buff", "debuff"};
		
		words.addAll(Arrays.asList(values));
		
		int index = randomGenerator.nextInt(words.size());
		String theWord = words.get(index);
		
		return theWord;
	} 
}
