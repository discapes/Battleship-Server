package server.battleship.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.HashSet;

public class ConfigReader
{	
	public static GameConfig read(String gameConfigFile) {
		GameConfig gameConfig = null;
		try {
			FileInputStream fileIn = new FileInputStream("gameconfig.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			gameConfig = (GameConfig) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("GameConfig class not found");
			c.printStackTrace();
		} 
		return gameConfig;

	}
	
	static MissileSilo getMissileSilo(String missileSiloFile) {
		MissileSilo n = null;
		try {
			FileInputStream fileIn = new FileInputStream("missilesilo.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			n = (MissileSilo) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("MissileSilo class not found");
			c.printStackTrace();
		} 
		return n;
	}
	static HashMap<String, HashSet<Block>> getShipMap(String shipMapFile) {
		HashMap<String, HashSet<Block>> ships = new HashMap<String, HashSet<Block>>();
		
		HashSet<Block> s1 = new HashSet<Block>();
		for (int x = 0, y = 0; x < 5; x++) {
			s1.add(new Block(x, y));
		}
		ships.put("First Ship", s1);
		
		HashSet<Block> s2 = new HashSet<Block>();
		for (int x = 2, y = 2; y < 5; y++) {
			s2.add(new Block(x, y));
		}
		ships.put("Second Ship", s2);
		
		HashSet<Block> s3 = new HashSet<Block>();
		for (int x = 4, y = 4; x >= 0; x--) {
			s3.add(new Block(x, y));
		}
		ships.put("Third Ship", s3);
		

		return ships;
	}
}
