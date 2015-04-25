package leetcode;

public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] firstprices = new int [prices.length];
        int[] secondprices = new int [prices.length];
        int firstmin = prices[0], firstmaxprofit = 0;
        int secondmax = prices[prices.length - 1], secondmaxprofit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < firstmin) {
                firstmin = prices[i];
            }
            firstmaxprofit = Math.max(firstmaxprofit, prices[i] - firstmin);
            firstprices[i] = firstmaxprofit;
        }
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > secondmax) {
                secondmax = prices[i];
            }
            secondmaxprofit = Math.max(secondmaxprofit, secondmax - prices[i]);
            secondprices[i] = secondmaxprofit;
        }
        int max = firstprices[0] + secondprices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, firstprices[i] + secondprices[i]);
        }
        return max;
    }
}
