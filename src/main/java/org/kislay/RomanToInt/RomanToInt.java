package org.kislay.RomanToInt;

import java.util.Map;

class RomanToInt {

    Map<String, Integer> romanCombinationSingle = Map.of("I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000);
    Map<String, Integer> romanCombinationMultiple = Map.of("IV", 4,
            "IX", 9,
            "XL", 40,
            "XC", 90,
            "CD", 400,
            "CM", 900);
    public int romanToInt(String s) {
        Integer result = 0;
        for (int currentPosition = s.length() - 1; currentPosition >= 0;) {
            int oneLessThanCurrentPosition = currentPosition - 1;
            if (oneLessThanCurrentPosition >= 0) {
                String substringTwo = s.substring(oneLessThanCurrentPosition, currentPosition + 1);
                if (romanCombinationMultiple.containsKey(substringTwo)) {
                    result += romanCombinationMultiple.get(substringTwo);
                    currentPosition = currentPosition - 2;
                } else {
                    String substringOne = s.substring(currentPosition, currentPosition + 1);
                    result += romanCombinationSingle.get(substringOne);
                    currentPosition = currentPosition - 1;
                }
            } else {
                String substringOne = s.substring(currentPosition, currentPosition + 1);
                result += romanCombinationSingle.get(substringOne);
                currentPosition = currentPosition - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("III"));
        System.out.println(romanToInt.romanToInt("IV"));
        System.out.println(romanToInt.romanToInt("IX"));
        System.out.println(romanToInt.romanToInt("LVIII"));
        System.out.println(romanToInt.romanToInt("LVI"));
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
        System.out.println(romanToInt.romanToInt("MCM"));
    }
}
