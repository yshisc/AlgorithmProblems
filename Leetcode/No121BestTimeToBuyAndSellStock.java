package Leetcode;
/**
 * @author xiangfeidong
 *
 * 121.Best Time to Buy and Sell Stock
 *
 * If we sell at a time, max profit = current price - min price before this price.
 * So we traverse the array, record min price so far, calculate current price - min price, and update max profit if necessary.
 */
public class No121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
