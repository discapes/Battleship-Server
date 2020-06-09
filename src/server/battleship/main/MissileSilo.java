package server.battleship.main;

import java.io.Serializable;

abstract class MissileSilo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String missileSiloType;
	
	abstract Missile fireCurrentMissile();
	abstract String getCurrentMissileName();
	String getMissileSiloType() { return missileSiloType; };
	
	String getMissileNameAt(int index) { return "error"; }
	int getNumOfMissile(int missileType) { return -1; }
	int getTotalNumOfMissiles() { return -1; }
	void setCurrentMissile(int missileType) {}
	int getMissileIDAt(int index) { return -1; }
	int getCurrentMissileID() { return -1; }
}
