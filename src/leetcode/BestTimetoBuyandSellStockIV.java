package leetcode;

public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int maxPro = 0;
        int maxTrade = 0;
        for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				maxPro += (prices[i] - prices[i-1]);
				maxTrade ++;
			}
		}
        if (maxTrade <= k) {
			return maxPro;
		}
        int[][] local = new int [k+1][prices.length];
        int[][] global = new int [k+1][prices.length];
        for (int i = 1; i <= k; i++) {
			for (int j = 1; j < prices.length; j++) {
				int diff = prices[j] - prices[j-1];
				local[i][j] = Math.max(global[i-1][j-1], local[i][j-1] + diff);
				global[i][j] = Math.max(global[i][j-1], local[i][j]);
			}
		}
        return global[k][prices.length-1];
    }
}
