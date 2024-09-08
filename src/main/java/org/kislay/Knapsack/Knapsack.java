package org.kislay.Knapsack;

class Knapsack {

    int knapSack(int W, int[] wt, int[] val) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.knapSack(4, new int[] { 4, 5, 1 }, new int[] { 1, 2, 3 }));
    }
}
