package com.fugu.test.smartfox_server.service;

import com.fugu.test.smartfox_server.model.Game;
import com.fugu.test.smartfox_server.model.Word;

public class GameService {
	
	private Game game;
	
	public GameService(Game game) {
		this.game = game;
	}
	
	public Game init() {
		game.init(Word.getNewWord());
		return game;
	}
	
	public Game play() {
		game.guess();
		return game;
	}
	
}
