package leetcode;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
    	int rLen = dungeon.length,  cLen = dungeon[0].length;
    	int[][] minHealth = new int [rLen][cLen];
    	minHealth[rLen - 1][cLen - 1] = Math.max(1, 1 - dungeon[rLen - 1][cLen - 1]);
    	
    	for (int i = rLen - 2; i >= 0; i--) {
			minHealth[i][cLen - 1] = Math.max(1, minHealth[i + 1][cLen - 1] - dungeon[i][cLen - 1]);
		}
    	
    	for (int i = cLen - 2; i >= 0; i--) {
    		minHealth[rLen - 1][i] = Math.max(1, minHealth[rLen - 1][i + 1] - dungeon[rLen - 1][i]);
		}
    	
    	for (int i = rLen - 2; i >= 0; i--) {
			for (int j = cLen - 2; j >= 0; j--) {
				int rHealth = Math.max(1, minHealth[i][j+1] - dungeon[i][j]);
				int dHealth = Math.max(1, minHealth[i+1][j] - dungeon[i][j]);
				minHealth[i][j] = Math.min(rHealth, dHealth);			
			}
		}
    	return minHealth[0][0];
    }
}
