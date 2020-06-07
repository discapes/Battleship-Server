package server.battleship.main;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;

public class GameContainer
{
	
	private BattleshipGameInterface game;
	void setGame(BattleshipGameInterface game) {
		this.game = game;
	}
	
	public GameContainer(GameConfig gameConfig)
	{
		MissileSilo missileSilo = GameConfig.getMissileSilo("missileSiloFile.serial");
		HashMap<String, HashSet<Block>> shipMap = GameConfig.getShipMap("shipMapFile.serial");
		game = new BattleshipGame(missileSilo, shipMap, gameConfig);
	}

	public Object call(String inputLine)
	{
		String[] splitLine = inputLine.split("\\s+");
		Object[] parsedArgs = parseArgs(splitLine);
		Class<?>[] argsClasses = parseArgClasses(parsedArgs);
		try { return game.getClass().getMethod(splitLine[0], argsClasses).invoke(game, parsedArgs);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {}
		return null;
	}
	
	private Object[] parseArgs(String[] args) {
		Object[] parsedArgs = new Object[args.length - 1];
		for(int i = 1; i < args.length; i++) {
			String arg = args[i];
			String[] argSplit = arg.split(":");
		
			switch (argSplit[0]) {
			case "int":
				parsedArgs[i-1] = Integer.parseInt(argSplit[1]);
				break;
			case "str":
				parsedArgs[i-1] = argSplit[1];
				break;
			}
		}
		return parsedArgs;
	}

	private Class<?>[] parseArgClasses(Object[] parsedArgs) {
		Class<?>[] classes = new Class[parsedArgs.length];
		for (int i = 0; i < parsedArgs.length; i++) {
			classes[i] = parsedArgs[i].getClass();
			if( classes[i] == Integer.class ) {
				classes[i] = int.class;
			}
		}
		return classes;
	}
	
}
