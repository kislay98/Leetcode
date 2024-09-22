package org.kislay.ATOI;

class StringToInt {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int sign = getSign(s.charAt(0));

        int startIdx = getStartIndex(s);
        int endIndex = getEndIndex(s, startIdx);
        if (endIndex - startIdx > 10) {
            return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        long p = 1;
        long num = 0;
        for (int i = endIndex; i >= startIdx; i--) {
            int digit = s.charAt(i) - '0';
            num += digit*p;
            p *= 10;
        }
        num *= sign;
        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) num;
    }

    int getEndIndex(String s, int startIndex) {
        int endIndex = startIndex;
        for (; endIndex < s.length(); endIndex++) {
            int digit = s.charAt(endIndex) - '0';
            if (digit >= 10 || digit <= -1) {
                break;
            }
        }
        return --endIndex;
    }

    int getStartIndex(String s) {
        int startIdx = s.charAt(0) == '-' || s.charAt(0) == '+' ? 1: 0;
        while (startIdx < s.length()) {
            int digit = s.charAt(startIdx) - '0';
            if (digit == 0) {
                startIdx++;
            } else if (digit >= 10 || digit <= -1) {
                return 0;
            } else {
                break;
            }
        }
        return startIdx;
    }

    int getSign(char ch) {
        return ch == '-' ? -1 : 1;
    }
}
