package org.kislay;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int[] soln = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (sumMap.containsKey(target - nums[i])) {
                soln[0] = sumMap.get(target - nums[i]);
                soln[1] = i;
                break;
            }
            sumMap.put(nums[i], i);
        }
        return soln;
    }

    public int[] twoSumSorted(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length  - 1;
        int[] soln = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right --;
            } else {
                soln[0] = left + 1;
                soln[1] = right + 1;
                break;
            }
        }
        return soln;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        twoSum.twoSumSorted(new int[]{2,7,11,15}, 9);
    }

}
