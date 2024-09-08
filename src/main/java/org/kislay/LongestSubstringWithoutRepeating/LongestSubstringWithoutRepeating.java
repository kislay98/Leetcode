package org.kislay.LongestSubstringWithoutRepeating;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int startPointer = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxLength = -1;
        int currLength;
        for (int endPointer = 0;endPointer < s.length(); endPointer++) {
            Character c = s.charAt(endPointer);
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) + 1);
            } else {
                freqMap.put(c, 1);
            }
            if (freqMap.get(c) > 1) {
                // move start pointer untill its equalto endpointer, remove all elements along from freq map
                // currLength = 1, freqMap has one element
                startPointer = moveStartPointerTillEndPointersCharIsFoundOnce(startPointer, endPointer, freqMap, s);
            } else {
                currLength = endPointer - startPointer + 1;
                maxLength = Math.max(currLength, maxLength);
            }
        }
        return maxLength;
    }

    private int moveStartPointerTillEndPointersCharIsFoundOnce(int startPointer, int endPointer,
                                                                Map<Character, Integer> freqMap,
                                                                String s) {
        Character endPointersChar = s.charAt(endPointer);
        while (startPointer <= endPointer) {
            Character currentStartPointerChar = s.charAt(startPointer);
            if (currentStartPointerChar.equals(endPointersChar)) {
                freqMap.put(endPointersChar, 1);
                startPointer++;
                break;
            } else {
                freqMap.remove(currentStartPointerChar);
                startPointer++;
            }
        }
        return startPointer;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating longestSubstringWithoutRepeating = new LongestSubstringWithoutRepeating();
        System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring("dvdf"));
    }

}
