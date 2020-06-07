package server.battleship.socketinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server.battleship.main.GameConfig;
import server.battleship.main.GameContainer;

class ResponderThread extends Thread
{

	private Socket clientSocket;
	private GameContainer gameContainer;

	ResponderThread(Socket clientSocket, ServerConfig config)
	{
		this.clientSocket = clientSocket;
		GameConfig gameConfig = GameConfig.read(config.getDefaultGameConfig());
		this.gameContainer = new GameContainer(gameConfig);
	}

	public void run()
	{
	try (
		BufferedReader stringIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		ObjectOutputStream objectOut = new ObjectOutputStream(clientSocket.getOutputStream());				)
	{
		String inputLine;

		while ((inputLine = stringIn.readLine()) != null)
		{
			if (inputLine.equals("Bye")) break;
			objectOut.writeObject(gameContainer.call(inputLine));
		}
		
		clientSocket.close();
	} 
	catch (IOException e) { e.printStackTrace(); }
	}
}
