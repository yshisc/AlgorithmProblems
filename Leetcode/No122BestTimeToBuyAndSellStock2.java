package Leetcode;
/**
 * @author xiangfeidong
 *
 * 122.Best Time to Buy and Sell Stock II
 *
 * Draw a price trend line chart, our task is to find all ascending line.
 */
public class No122BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return maxProfit;
    }
}
