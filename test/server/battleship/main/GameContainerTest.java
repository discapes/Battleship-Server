package server.battleship.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameContainerTest
{

	private GameContainer gameContainer;
	
	@Before
	public void setUp() throws Exception
	{
		this.gameContainer = new GameContainer(new GameConfig());	
		gameContainer.setGame(new BattleshipGameStub(null, null, null));
	}

	@After
	public void tearDown() throws Exception
	{
		gameContainer = null;
	}

	@Test
	public void basicFunctionTest()
	{
		assertEquals("myString", (String)gameContainer.call("myFunction"));
	}
	
	@Test
	public void invalidFunctionTest()
	{
		assertNull(gameContainer.call("doesntexist"));
	}
	
	@Test
	public void IntegerParameterTest()
	{
		assertEquals(7, (int)gameContainer.call("addFive int:2"));
	}
	
	@Test
	public void StringParameterTest()
	{
		assertEquals("carbee", (String)gameContainer.call("cat str:car str:bee"));
	}
}
