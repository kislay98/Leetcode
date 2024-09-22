package org.kislay;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class GenerateMissingData {
    public String generateMissingData(String str, int N) {
        Map<Character, Integer> freqMap = getFreqMap(str);
        if (freqMap.size() > N) return "-1";
        int timesFnCalled = 0;
        int maxFreqPossible = Collections.max(freqMap.values());
        Map<Character, Integer> finalAns = new HashMap<>();
        int prefixACount = 0;
        while (timesFnCalled < maxFreqPossible) { //minimize fn call
            int reqN = 0;
            Map<Character, Integer> possibleAns = new HashMap<>();
            for (Map.Entry<Character, Integer> eachFreq: freqMap.entrySet()) {
                int freq = (int) Math.ceil((double) eachFreq.getValue() / (timesFnCalled + 1));
                reqN += freq;
                if (reqN > N) break;
                possibleAns.put(eachFreq.getKey(), freq);
            }
            if (reqN <= N) {
                prefixACount = N - reqN;
                finalAns = possibleAns; // if here -> we have the optimal ans
                break;
            }
            timesFnCalled++;
        }
        return generateSortedStringFromMap(prefixACount, finalAns);
    }

    public static void main(String[] args) {
        GenerateMissingData generateMissingData = new GenerateMissingData();
        System.out.println(generateMissingData.generateMissingData("ab", 4));
    }

    private Map<Character,Integer> getFreqMap(String string) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch: string.toCharArray()) {
            int currentCount = freqMap.getOrDefault(ch, 0);
            freqMap.put(ch, ++currentCount);
        }
        return freqMap;
    }

    private String generateSortedStringFromMap(int prefixACount, Map<Character, Integer> fmap) {
        StringBuilder inputStrBuilder = new StringBuilder();
        inputStrBuilder.append(String.valueOf('a').repeat(Math.max(0, prefixACount)));
        for (Map.Entry<Character, Integer> entry : fmap.entrySet()) {
            int freq = entry.getValue();
            inputStrBuilder.append(String.valueOf(entry.getKey()).repeat(Math.max(0, freq)));
        }
        char[] charArray = inputStrBuilder.toString().toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
