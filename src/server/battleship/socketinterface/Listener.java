package server.battleship.socketinterface;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Listener
{	
	private static Listener instance;
	
	static Listener get() {
		return instance; }
	
	static void make(ServerConfig config) {
		instance = new Listener(config); }

	
	private ServerConfig config;

	private Listener(ServerConfig config)
	{
		this.config = config;
	}
	
	private boolean listening = true;
	void setListening(boolean listening) { this.listening = listening; }
	
	void listen() throws IOException {
		try( ServerSocket serverSocket = new ServerSocket(config.getPort()) ) {
			while (listening) {
				Socket clientSocket = serverSocket.accept();
				new ResponderThread(clientSocket, config).start();;
			}
		}
	}
	
}
