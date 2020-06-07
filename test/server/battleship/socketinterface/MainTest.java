package server.battleship.socketinterface;


import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class MainTest
{
	
//	@BeforeEach
//	void setUp() throws Exception
//	{
//	}
//
//	@AfterEach
//	void tearDown() throws Exception
//	{
//	}

	@Test
	public void test() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException
	{
//		ProcessBuilder pb = new ProcessBuilder("/usr/bin/java", "-jar", "/home/miika/Downloads/Documents/Server.jar");
//		pb.directory(new File("/home/miika/Downloads/Documents"));
//		Process p = pb.start();
//		
//		Thread.sleep(200);
		
	    Socket socket = new Socket("localhost", 4444);
        PrintWriter stringOut = new PrintWriter(socket.getOutputStream(), true);
       	ObjectInputStream oIn = new ObjectInputStream(socket.getInputStream());
       	
       	stringOut.println("getCurrentMissile");
       	String missile = (String) oIn.readObject();
       	assertEquals("missile", missile);
       	socket.close();
       	
//		p.destroy();
	}

}
