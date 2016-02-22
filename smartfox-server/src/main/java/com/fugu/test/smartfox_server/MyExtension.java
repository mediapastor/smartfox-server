package com.fugu.test.smartfox_server;

import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class MyExtension extends SFSExtension {
	
	@Override
	public void init() {
		trace("Hello, this is my first SFS2X Extension!");
		
		// Add a new Request Handler
		addRequestHandler("math", MathHandler.class);

		// Add a new SFSEvent Handler
	    addEventHandler(SFSEventType.USER_LOGIN, LoginEventHandler.class);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
