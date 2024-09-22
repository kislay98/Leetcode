package org.kislay.SubArraySum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] sum = new int[length];
        Map<Integer, Integer> sumFreq = new HashMap<>();
        int runningSum = 0;
        sumFreq.put(0,1);
        int totalSolutions = 0;
        for (int i = 0; i <= length - 1; i++) {
            runningSum += nums[i];
            sum[i] = runningSum;
            if (sumFreq.containsKey(sum[i] - k)) {
                totalSolutions += sumFreq.get(sum[i] - k).intValue();
            }
            if (sumFreq.containsKey(sum[i])) {
                sumFreq.put(sum[i], sumFreq.get(sum[i]) + 1);
            } else {
                sumFreq.put(sum[i], 1);
            }
        }
        return totalSolutions;
    }
}
