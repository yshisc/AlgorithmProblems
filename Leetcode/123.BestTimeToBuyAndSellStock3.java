package Leetcode;
/**
 * @author xiangfeidong
 *
 * 123.Best Time to Buy and Sell Stock III
 */
public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }

        //Get max profit in prices[0~i].
        int[] left = new int[n];
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        //Get max profit in prices[i~n-1].
        int[] right = new int[n];
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }

        //Find max profit.
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
    }
}
