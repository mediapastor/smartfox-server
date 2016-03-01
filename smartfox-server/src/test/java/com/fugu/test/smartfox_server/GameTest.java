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
    	game.guess("t");
    	game.guess("s");
    	
    	assertEquals("failure - wordShow are not same", "t*st", game.getWordToShwo());
    }
    
    /**
     * Test isWon status
     */
    @Test
    public void testIsWon() {        
    	game.guess("t");
    	game.guess("e");
    	game.guess("s");
    	
    	assertTrue("failure - isWon status is not true", game.isWon());
    	assertTrue("failure - isOver status is not true", game.isOver());
    }
    
    /**
     * Test isWon status
     */
    @Test
    public void testIsNotWon() {        
    	game.guess("t");
    	game.guess("e");
    	
    	assertFalse("failure - isWon status is not false", game.isWon());
    }
    
    /**
     * Test game over status
     */
    @Test
    public void testIsOver() {
    	for(int i=0; i<10; i++) {
    		game.guess("r");
    	}
    	assertTrue("failure - isOver status is not true", game.isOver());
    }
    
    /**
     * Test game over status
     */
    @Test
    public void testIsNotOver() {
    	for(int i=0; i<9; i++) {
    		game.guess("r");
    	}
    	
    	assertFalse("failure - isOver status is not false", game.isOver());
    }
    
    @Test
    public void testGuessCount() {
    	game.guess("r");
    	game.guess("r");
    	assertEquals("failure - guess count is not qualt to 2", 2, game.getGuessCount());
    }
}
