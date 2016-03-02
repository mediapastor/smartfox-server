package com.fugu.test.smartfox_server.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fugu.test.smartfox_server.Util.Assert;
import com.fugu.tim.hibernate_repository_pattern.db.Persistable;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;

@Entity
public class Game implements Persistable {
	
	private static final long serialVersionUID = 2419597583961520285L;

	private List<String> word;
	
	private int id;
	private String wordToShow = "";
	private String guess;
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
	
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * @return the wordToShow
	 */
	public String getWordToShow() {
		return wordToShow;
	}




	/**
	 * @param wordToShow the wordToShow to set
	 */
	public void setWordToShow(String wordToShow) {
		this.wordToShow = wordToShow;
	}




	/**
	 * @return the guess
	 */
	public String getGuess() {
		return guess;
	}




	/**
	 * @param guess the guess to set
	 */
	public void setGuess(String guess) {
		this.guess = guess;
	}




	/**
	 * @return the guessesHit
	 */
	@Transient
	public List<String> getGuessesHit() {
		return guessesHit;
	}




	/**
	 * @param guessesHit the guessesHit to set
	 */
	public void setGuessesHit(List<String> guessesHit) {
		this.guessesHit = guessesHit;
	}




	/**
	 * @return the guessesMissed
	 */
	@Transient
	public List<String> getGuessesMissed() {
		return guessesMissed;
	}




	/**
	 * @param guessesMissed the guessesMissed to set
	 */
	public void setGuessesMissed(List<String> guessesMissed) {
		this.guessesMissed = guessesMissed;
	}




	/**
	 * @param guessCount the guessCount to set
	 */
	public void setGuessCount(int guessCount) {
		this.guessCount = guessCount;
	}




	/**
	 * @param isOver the isOver to set
	 */
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}




	/**
	 * @param isWon the isWon to set
	 */
	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}



	public void init(String str) {
		
		String[] wordInArray = str.split("");
		List<String> wordInList = Arrays.asList(wordInArray);
		
		this.word = wordInList;
	}
	
	
	
	public boolean guess() {
		
		Assert.isSingleChar(this.guess);
		
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
	
	/**
	 * Convert object to SFSObject
	 * 
	 * @return SFSObject 
	 */
	public SFSObject toSFSObject() {
		
		ISFSObject sfso = new SFSObject();
		
		sfso.putUtfString("wordToShow", getWordToShow());
		sfso.putUtfString("guess", getGuess());
		sfso.putUtfStringArray("guessesHit", getGuessesHit());
		sfso.putUtfStringArray("guessesMissed", getGuessesMissed());
		sfso.putInt("guessCount", getGuessCount());
		sfso.putBool("isOver", isOver());
		sfso.putBool("isWon", isWon());
		
		return SFSObject.newFromObject(this);
	}
	
	/**
	 * Convert SFSObject to object
	 * 
	 * @param sfsObject
	 * @return Game
	 */
	public static Game fromSFSObject(ISFSObject sfsObject) {
		
		Game game = new Game();
		
		game.setWordToShow(sfsObject.getUtfString("wordToShow"));
		game.setGuess(sfsObject.getUtfString("guess"));
		game.setGuessesHit(new ArrayList<String>(sfsObject.getUtfStringArray("guessesHit")));
		game.setGuessesMissed(new ArrayList<String>(sfsObject.getUtfStringArray("guessesHit")));
		game.setGuessCount(sfsObject.getInt("guesscount"));
		game.setOver(sfsObject.getBool("isOver"));
		game.setWon(sfsObject.getBool("isWon"));
		
		return game;
	}
	
}
