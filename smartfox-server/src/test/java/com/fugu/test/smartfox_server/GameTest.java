package com.fugu.test.smartfox_server;

import org.junit.Before;
import org.junit.Test;

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
    
    	
    @Test
    public void testShowWrod() {        
    	String wordShown = game.guess("t");
    	wordShown = game.guess("s");
    	assertEquals("failure - wordShow are not same", "t*st", wordShown);
    }
    
    @Test
    public void testIsWon() {        
    	game.guess("t");
    	game.guess("e");
    	game.guess("s");
    	assertTrue("failure - isWon status is not true", game.isWon());
    }
    
    @Test
    public void testIsNotWon() {        
    	game.guess("t");
    	game.guess("e");
    	assertFalse("failure - isWon status is not true", game.isWon());
    }
}
