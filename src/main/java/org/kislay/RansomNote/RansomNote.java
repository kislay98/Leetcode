package org.kislay.RansomNote;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> magazineFreqMap = getFreqMap(magazine);
        for(char ch: ransomNote.toCharArray()) {
            Integer i = magazineFreqMap.get(ch);
            if (i == null) {
                return false;
            }
            if (i == 1) {
                magazineFreqMap.remove(ch);
            } else {
                magazineFreqMap.put(ch, --i);
            }
        }
        return true;
    }

    private Map<Character,Integer> getFreqMap(String string) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch: string.toCharArray()) {
            int currentCount = freqMap.get(ch) == null? 0 : freqMap.get(ch);
            freqMap.put(ch, ++currentCount);
        }
        return freqMap;
    }

}
