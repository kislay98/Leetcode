package org.kislay.LongestPalindrome;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> freqMap = getFreqMap(s);
        int maxLength = 0;
        int maxOddValue = 0;
        boolean firstOddNotFound = true;
        for (Integer value : freqMap.values()) {
            if (value % 2 == 0) {
                maxLength += value;
            } else if (firstOddNotFound) {
                firstOddNotFound = false;
                maxLength += value;
            } else {
                maxLength += (value - 1);
            }
        }
        return maxLength + maxOddValue;
    }

    private Map<Character,Integer> getFreqMap(String string) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch: string.toCharArray()) {
            int currentCount = freqMap.get(ch) == null? 0 : freqMap.get(ch);
            freqMap.put(ch, ++currentCount);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        longestPalindrome.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichthey");
    }

}
