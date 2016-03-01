package com.fugu.test.smartfox_server;

import com.fugu.test.smartfox_server.Util.Util;
import com.fugu.test.smartfox_server.model.Game;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class HangManExtension extends SFSExtension{
	
	private Game game;
	
	@Override
	public void init() {
		
		Util.logInfo("Smartfox server initialized!");
		
		// Add Request Listener
		
		// Start Request
		// Guess Request
		// Reset Request
		
		// Add Event Listener
		
		// User Login Successful Event
		// User Login Failed Event
		
	}
	
	@Override
	public void destroy() {
		
		super.destroy();
		Util.logInfo("Smartfox server destroyed!");
		
	}

}
