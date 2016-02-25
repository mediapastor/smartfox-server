package com.fugu.test.smartfox_server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fugu.test.smartfox_server.Util.Assert;

public class Game {
	
	private List<String> word;
	private String wordToShow = "";
	
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
	
	public boolean guess(String guess) {
		
		Assert.isSingleChar(guess);
		
		if (match(guess)) {
			this.guessesHit.add(guess);
		} else {
			this.guessesMissed.add(guess);
		}
		
		this.wordToShow = showWord();
		
		// check player guess whole word or not
		if (this.wordToShow.indexOf('*') == -1) {
			this.isOver = true;
			this.isWon = true;
			System.out.println(this.wordToShow.indexOf('*'));
		}
		
		this.guessCount++;
		
		if (guessCount == guessCountLimit) {
			this.isOver = true;
		}
		
		return isOver();
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
	 * Get word to be shown to player
	 * 
	 * @return word like "t**t" to help player next guess
	 */
	public String getWordToShwo() {
		return this.wordToShow;
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
		
		this.wordToShow = "";
		
		
		for(String c : this.word) {

			if(guessesHit.contains(c)) {
				this.wordToShow += c;
			} else {
				this.wordToShow += "*";
			}			
			
		}
		System.out.println(wordToShow);
		return wordToShow;
		
	}
	
}
