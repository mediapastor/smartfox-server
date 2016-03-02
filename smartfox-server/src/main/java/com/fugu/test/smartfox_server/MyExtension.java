package com.fugu.test.smartfox_server;

import com.fugu.test.smartfox_server.handler.GameHandler;
import com.fugu.test.smartfox_server.handler.LoginHandler;
import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class MyExtension extends SFSExtension {
	
	@Override
	public void init() {

		// Add a new Request Handler
		addRequestHandler("game", GameHandler.class);

		// Add a new SFSEvent Handler
	    addEventHandler(SFSEventType.USER_LOGIN, LoginHandler.class);
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

}
