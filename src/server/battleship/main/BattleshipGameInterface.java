
package server.battleship.main;

import java.util.HashSet;

interface BattleshipGameInterface
{

	HashSet<int[]> shootMissile(int x, int y);

	String getCurrentMissileName();
	String getMissileNameAt(int index);
	int getNumOfMissile(int missileType);
	void setCurrentMissile(int missileType);
	int getTotalNumOfMissiles();
	
	String getMissileSiloType();

	int getCurrentMissileID();

	int getMissileIDAt(int index);

	int getCols();

	int getRows();
}
