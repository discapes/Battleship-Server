package server.battleship.socketinterface;

class ServerThread extends Thread
{
	
	@Override
	public void run() {
		String[] args = { "serverConfig" };
		Main.main(args);
	}
}
