package org.kislay.Kadane;

public class Kadane {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int[] current = new int[nums.length];
        current[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current[i] = Math.max(nums[i], current[i - 1] + nums[i]);
            max = Math.max(max, current[i]);
        }
        return max;
    }
}
