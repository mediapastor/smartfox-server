package com.fugu.test.smartfox_server;

import com.smartfoxserver.v2.core.ISFSEvent;
import com.smartfoxserver.v2.core.SFSEventParam;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.smartfoxserver.v2.exceptions.SFSLoginException;
import com.smartfoxserver.v2.extensions.BaseServerEventHandler;

public class LoginEventHandler extends BaseServerEventHandler
{
    @Override
    public void handleServerEvent(ISFSEvent event) throws SFSException
    {
        String username = (String) event.getParameter(SFSEventParam.LOGIN_NAME); 
        String password = (String) event.getParameter(SFSEventParam.LOGIN_PASSWORD);
         
        if (username.equals("tim") && password.equals("1234")) {
        	System.out.printf("Login success with username %s and password %s.%n", username, password);
        } else {
        	throw new SFSLoginException("Access denied! Wrong username or password!");
        }
            
    }
}
