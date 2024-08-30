package org.kislay;

import java.util.Arrays;
import java.util.OptionalInt;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        boolean foundSmaller = false;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    foundSmaller = true;
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (!foundSmaller) {
                dp[i] = 1;
            }
            foundSmaller = false;
        }
        return Arrays.stream(dp).max().orElse(0);
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6}));
    }

}
