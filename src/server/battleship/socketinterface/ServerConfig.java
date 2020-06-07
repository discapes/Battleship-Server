package server.battleship.socketinterface;

import java.io.Serializable;

class ServerConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int port = 4444;
	int getPort() { return port; }
	
	private String defaultGameConfigFile;
	String getDefaultGameConfig() { return defaultGameConfigFile; }
}
