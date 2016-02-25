package com.fugu.test.smartfox_server;

import com.smartfoxserver.bitswarm.sessions.ISession;
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
        String cryptPassword = (String) event.getParameter(SFSEventParam.LOGIN_PASSWORD);
        ISession session = (ISession)event.getParameter(SFSEventParam.SESSION);
        
        ;
         
        if (username.equals("tim") && getApi().checkSecurePassword(session, "1234", cryptPassword)) {
        	System.out.printf("Login success with username %s and password %s.%n", username, cryptPassword);
        } else {
        	throw new SFSLoginException("Access denied! Wrong username or password! username:" + username + " cryptPasswordStatus:" + getApi().checkSecurePassword(session, "1234", cryptPassword));
        }
            
    }
}
