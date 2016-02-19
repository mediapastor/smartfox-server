package com.fugu.test.smartfox_server;

import com.smartfoxserver.v2.extensions.SFSExtension;

public class MyExtension extends SFSExtension {
	
	public void init() {
		this.addRequestHandler("math", MathHandler.class);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
