package server.battleship.main;

import java.util.HashMap;
import java.util.HashSet;

class BattleshipGame implements BattleshipGameInterface
{
	
	private MissileSilo missileSilo;
	private HashMap<String, HashSet<Block>> shipMap;
	private int cols;
	private int rows;
	
	public BattleshipGame(MissileSilo missileSilo, HashMap<String, HashSet<Block>> shipMap, GameConfig gameConfig)
	{
		this.missileSilo = missileSilo;
		this.shipMap = shipMap;
		this.cols = gameConfig.getCols();
		this.rows = gameConfig.getRows();
	}

	@Override
	public HashSet<int[]> shootMissile(int x, int y) {
		Missile missile = missileSilo.fireCurrentMissile();
		if (missile == null) return new HashSet<int[]>();
		switch (missile) {
		case SPLASH:
			return Missile.splash(shipMap, x, y);
		case H_LINE:
			return Missile.h_line(shipMap, y);
		case V_LINE:
			return Missile.v_line(shipMap, x);
		default:
			return Missile.single(shipMap, x, y);
		}
	}
	
	@Override public int getCols() { return this.cols; }
	@Override public int getRows() { return this.rows; }
	
	Missile fireCurrentMissile() { return missileSilo.fireCurrentMissile(); }
	@Override public String getCurrentMissileName() { return missileSilo.getCurrentMissileName(); }
	@Override public String getMissileNameAt(int index) { return missileSilo.getMissileNameAt(index); }
	@Override public int getNumOfMissile(int missileType) { return missileSilo.getNumOfMissile(missileType); }
	@Override public int getTotalNumOfMissiles() { return missileSilo.getTotalNumOfMissiles(); }
	@Override public void setCurrentMissile(int missileType) { missileSilo.setCurrentMissile(missileType); }

	@Override public String getMissileSiloType() { return missileSilo.getMissileSiloType(); }
	@Override public int getMissileIDAt(int index) { return missileSilo.getMissileIDAt(index); }
	@Override public int getCurrentMissileID() { return missileSilo.getCurrentMissileID(); }
}
