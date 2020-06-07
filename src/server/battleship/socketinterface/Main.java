package server.battleship.socketinterface;

import server.battleship.exceptions.InvalidConfigurationException;

public class Main
{

	public static void main(String[] args)
	{
	try //(	
		//FileInputStream fileIn = new FileInputStream(args[0]);
		//ObjectInputStream objectIn = new ObjectInputStream(fileIn); )
	{
		//Object configObject = objectIn.readObject();
		Object configObject = new ServerConfig();
		if(!(configObject instanceof ServerConfig)) { throw new InvalidConfigurationException(); }
		ServerConfig communicatorConfig = (ServerConfig) configObject;
		
		Listener.make(communicatorConfig);
		Listener.get().listen();
			
	} catch (Exception e) { e.printStackTrace(); }
	}
}
