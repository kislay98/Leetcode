package org.kislay;

import java.util.Arrays;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxValueInFuture = 0;
        int maxProfit = 0;
        for (int i = n-2; i >= 0; i--) {
            maxValueInFuture = Math.max(prices[i + 1], maxValueInFuture);
            maxProfit = Math.max(maxProfit, maxValueInFuture - prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BuySellStock buySellStock = new BuySellStock();
        buySellStock.maxProfit(new int[] {7,6,4,3,1});
    }
}
