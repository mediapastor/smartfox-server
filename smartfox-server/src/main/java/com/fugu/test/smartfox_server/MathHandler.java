package com.fugu.test.smartfox_server;

import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class MathHandler extends BaseClientRequestHandler {

	public void handleClientRequest(User player, ISFSObject params) {
		
		int n1 = params.getInt("n1");
		int n2 = params.getInt("n2");
		
		ISFSObject rtn = new SFSObject();
		rtn.putInt("sum", n1 + n2);
		
		MyExtension parentEx = (MyExtension) getParentExtension();
		parentEx.send("math", rtn, player);
	}

}
