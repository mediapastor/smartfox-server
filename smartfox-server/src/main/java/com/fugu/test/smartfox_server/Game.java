package com.fugu.test.smartfox_server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fugu.test.smartfox_server.Util.Assert;

public class Game {
	
	private List<String> word;	
	
	private int guessCount;
	private int guessCountLimit;
	private boolean isOver;
	private boolean isWon;
	private List<String> guessesHit;
	private List<String> guessesMissed;
	
	public Game() {
		
		this.isOver = false;
		this.guessCount = 0;
		this.guessCountLimit = 10;
		this.guessesHit = new ArrayList<>();
		this.guessesMissed = new ArrayList<>();
	}
	
	public void init(String str) {
		
		String[] wordInArray = str.split("");
		List<String> wordInList = Arrays.asList(wordInArray);
		
		this.word = wordInList;		
	}
	
	public String guess(String guess) {
		
		Assert.isSingleChar(guess);
		
		if (match(guess)) {
			this.guessesHit.add(guess);
		} else {
			this.guessesMissed.add(guess);
		}
		
		if (this.guessesHit.size() == word.size()) {
			this.isOver = true;
			this.isWon = true;
		}
		
		this.guessCount++;
		
		if (guessCount == guessCountLimit) {
			this.isOver = true;
		}
		
		return showWord();
	}
	
	/**
	 * 
	 * @return true if player won the game 
	 */
	public boolean isWon() {
					
		return this.isWon;
	}
	
	/**
	 * 
	 * @return true if game is over
	 */
	public boolean isOver() {
					
		return this.isOver;
	}
	
	/**
	 * Get count
	 * 
	 * @return count of guess
	 */
	public int getGuessCount() {
		return this.guessCount;
	}
	
	/**
	 * Check if guess match word
	 * 
	 * @param guess
	 * @return true if guess match word for the first time, else false
	 */
	private boolean match(String guess) {
		
		if (this.guessesHit.contains(guess)) {
			
			return false;
		}
		
		if (this.word.contains(guess)) {
			
			guessesHit.add(guess);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Get current word status
	 * 
	 * @return current word status to player
	 */
	private String showWord() {
		
		String wordToShow = "";
		
		
		for(String c : this.word) {

			if(guessesHit.contains(c)) {
				wordToShow += c;
			} else {
				wordToShow += "*";
			}			
			
		}

		return wordToShow;
	}
	
}
