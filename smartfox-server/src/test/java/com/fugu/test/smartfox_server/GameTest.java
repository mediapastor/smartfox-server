package com.fugu.test.smartfox_server;

import org.junit.Before;
import org.junit.Test;

import com.fugu.test.smartfox_server.model.Game;

import junit.framework.TestCase;

public class GameTest extends TestCase {

	private Game game;
	
    public GameTest(String name) {
    	super(name);
	}
	
    @Before
    protected void setUp() {
    	game = new Game();
    	game.init("test");
    }
    
    /**
     * Show word status
     */
    @Test
    public void testShowWrod() {        
    	game.setGuess("t");
    	game.guess();
    	game.setGuess("s");
    	game.guess();
    	
    	assertEquals("failure - wordShow are not same", "t*st", game.getWordToShwo());
    }
    
    /**
     * Test isWon status
     */
    @Test
    public void testIsWon() {
    	game.setGuess("t");
    	game.guess();
    	game.setGuess("e");
    	game.guess();
    	game.setGuess("s");
    	game.guess();
    	
    	assertTrue("failure - isWon status is not true", game.isWon());
    	assertTrue("failure - isOver status is not true", game.isOver());
    }
    
    /**
     * Test isWon status
     */
    @Test
    public void testIsNotWon() {        
    	game.setGuess("t");
    	game.guess();
    	game.setGuess("e");
    	game.guess();
    	
    	assertFalse("failure - isWon status is not false", game.isWon());
    }
    
    /**
     * Test game over status
     */
    @Test
    public void testIsOver() {
    	for(int i=0; i<10; i++) {
    		game.setGuess("r");
    		game.guess();
    	}
    	assertTrue("failure - isOver status is not true", game.isOver());
    }
    
    /**
     * Test game over status
     */
    @Test
    public void testIsNotOver() {
    	for(int i=0; i<9; i++) {
    		game.setGuess("r");
    		game.guess();
    	}
    	
    	assertFalse("failure - isOver status is not false", game.isOver());
    }
    
    @Test
    public void testGuessCount() {
    	game.setGuess("r");
    	game.guess();
    	game.setGuess("t");
    	game.guess();
    	assertEquals("failure - guess count is not qualt to 2", 2, game.getGuessCount());
    }
}
