package org.kislay.MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int threshold = nums.length/2;
        Map<Integer,Integer> freqMap = getFreqMap(nums);
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            if (entry.getValue() > threshold) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private Map<Integer,Integer> getFreqMap(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(Integer num: nums) {
            int currentCount = freqMap.get(num) == null? 0 : freqMap.get(num);
            freqMap.put(num, ++currentCount);
        }
        return freqMap;
    }

}
