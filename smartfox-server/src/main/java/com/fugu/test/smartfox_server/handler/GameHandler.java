package com.fugu.test.smartfox_server.handler;

import com.fugu.test.smartfox_server.MyExtension;
import com.fugu.test.smartfox_server.model.Game;
import com.fugu.test.smartfox_server.service.GameService;
import com.smartfoxserver.v2.annotations.MultiHandler;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class GameHandler extends BaseClientRequestHandler {
	
	/**
	 * Base Client Request Handler
	 */
	@Override
	public void handleClientRequest(User player, ISFSObject params) {
		// String command = params.getUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID);
		trace("params is : " + params.toString());
		
//		switch (command) {
//		case "gameinit": 
//			handleInit(player, params);
//			break;
//		case "gameguess": 
//			handleGuess(player, params);
//			break;
//		}
		
	}
	
	/**
	 * Initialize the game and create a new room for player
	 * 
	 * @param player
	 * @param params
	 */
	private void handleInit(User player, ISFSObject params) {
		// get request from SFSObject
		Game game = Game.fromSFSObject(params);
		
		// Application logic
		GameService service = new GameService(game);
		Game initedGame = service.init();
		
		// instantiate response SFSObject
		// send back response
		ISFSObject response = initedGame.toSFSObject();
		MyExtension parentEx = (MyExtension) getParentExtension();
		parentEx.send("gameinit", response, player);
	}
	
	/**
	 * Handle guess from player
	 * 
	 * @param player
	 * @param params
	 */
	private void handleGuess(User player, ISFSObject params) {
		// get request from SFSObject
		Game game = Game.fromSFSObject(params);
		
		// Application logic
		GameService service = new GameService(game);
		Game playedGame = service.guess();
		
		// instantiate response SFSObject
		// send back response
		ISFSObject response = playedGame.toSFSObject();
		MyExtension parentEx = (MyExtension) getParentExtension();
		parentEx.send("gameguess", response, player);
	}

}
