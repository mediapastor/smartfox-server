package com.fugu.test.smartfox_server.handler;

import com.fugu.test.smartfox_server.MyExtension;
import com.fugu.test.smartfox_server.model.Game;
import com.smartfoxserver.v2.annotations.MultiHandler;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;
import com.smartfoxserver.v2.extensions.SFSExtension;

@MultiHandler
public class GameHandler extends BaseClientRequestHandler {
	
	private Game game;
	
	@Override
	public void handleClientRequest(User player, ISFSObject params) {
		String command = params.getUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID);
		System.out.println("game." + command + " executed");
		
		switch (command) {
		case "init": 
			handleInit(player, params);
			break;
		}
		
	}
	
	/**
	 * Initialize the game and create a new room for player
	 * 
	 * @param player
	 * @param params
	 */
	private void handleInit(User player, ISFSObject params) {
		// get request from SFSObject
		// may use adapter pattern
		Game game = Game.fromSFSObject(params);
		int n1 = params.getInt("n1");
		int n2 = params.getInt("n2");
		
		// instantiate response SFSObject
		ISFSObject rtn = new SFSObject();
		rtn.putInt("sum", n1 + n2);
		
		// send back response
		MyExtension parentEx = (MyExtension) getParentExtension();
		parentEx.send("math.add", rtn, player);
	}

}
