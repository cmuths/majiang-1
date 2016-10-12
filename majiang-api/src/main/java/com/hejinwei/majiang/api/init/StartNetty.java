package com.hejinwei.majiang.api.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.hejinwei.majiang.api.socket.server.EntranceServer;

@Component
public class StartNetty implements InitializingBean {
	
	private static EntranceServer entranceServer = new EntranceServer();

	public void afterPropertiesSet() throws Exception {
		entranceServer.bind(9999);
	}

}
