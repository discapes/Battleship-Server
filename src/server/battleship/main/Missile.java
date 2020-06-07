package server.battleship.main;

import java.util.HashMap;
import java.util.HashSet;

enum Missile {
	V_LINE(0, "V-Line"),
	H_LINE(1, "H-Line"),
	SINGLE(2, "Single"),
	SPLASH(3, "Splash");

	private int value;
	private String name;

	private Missile(int value, String name) {
		this.value = value;
		this.name = name;
	}

	int getValue() {
		return value;
	}

	String getName() {
		return name;
	}
	
	static HashSet<int[]> splash(HashMap<String, HashSet<Block>> shipMap, int midX, int midY) {
		HashSet<int[]> hits = new HashSet<int[]>();
		for (int x = -1, y = -1; y < 2;) {
			for (HashSet<Block> ship : shipMap.values()) {
				for (Block block : ship) {
					block.hit();
					if (block.getX() == x+midX && block.getY() == y+midY) {
						int[] loc = { block.getX(), block.getY() };
						hits.add(loc);
					}
				}
			}
			if(x == 1) {
				x = -1;
				y++;
			} else {
				x++;
			}
		}
		return hits;
	}
	
	static HashSet<int[]> single(HashMap<String, HashSet<Block>> shipMap, int x, int y) {
		HashSet<int[]> hits = new HashSet<int[]>();
		for (HashSet<Block> ship : shipMap.values()) {
			for (Block block : ship) {
				block.hit();
				if (block.getX() == x && block.getY() == y) {
					int[] loc = { block.getX(), block.getY() };
					hits.add(loc);
				}
			}
		}
		return hits;
	}
	
	static HashSet<int[]> h_line(HashMap<String, HashSet<Block>> shipMap, int y) {
		HashSet<int[]> hits = new HashSet<int[]>();
		for (HashSet<Block> ship : shipMap.values()) {
			for (Block block : ship) {
				block.hit();
				if (block.getY() == y) {
					int[] loc = { block.getX(), block.getY() };
					hits.add(loc);
				}
			}
		}
		return hits;
	}
	
	static HashSet<int[]> v_line(HashMap<String, HashSet<Block>> shipMap, int x) {
		HashSet<int[]> hits = new HashSet<int[]>();
		for (HashSet<Block> ship : shipMap.values()) {
			for (Block block : ship) {
				block.hit();
				if (block.getX() == x) {
					int[] loc = { block.getX(), block.getY() };
					hits.add(loc);
				}
			}
		}
		return hits;
	}
}

