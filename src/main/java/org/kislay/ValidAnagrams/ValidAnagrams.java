package org.kislay.ValidAnagrams;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagrams {

    public boolean isAnagram(String s, String t) {
        /* Method 1:
        Map<Character, Integer> freqMapS = getFreqMap(s);
        Map<Character, Integer> freqMapT = getFreqMap(t);
        return freqMapS.equals(freqMapT);
         */
        Map<Character, Integer> freqMapS = getFreqMap(s);
        for(char ch: t.toCharArray()) {
            Integer i = freqMapS.get(ch);
            if (i == null) {
                return false;
            }
            if (i == 1) {
                freqMapS.remove(ch);
            } else {
                freqMapS.put(ch, --i);
            }
        }
        return freqMapS.isEmpty();
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
        ValidAnagrams validAnagrams = new ValidAnagrams();
        System.out.println(validAnagrams.isAnagram("anagram", "nagaram"));
    }

}
