package server.battleship.main;

import java.util.HashMap;
import java.util.HashSet;

class BattleshipGameStub extends BattleshipGame
{
	public BattleshipGameStub(MissileSilo missileSilo, HashMap<String, HashSet<Block>> shipMap, GameConfig gameConfig)
	{
		super(missileSilo, shipMap, gameConfig);
	}

	public String myFunction()
	{
		return "myString";
	}
	
	public int addFive(int i)
	{
		return i + 5;
	}
	
	public String cat(String a, String b)
	{
		return a + b;
	}
}
