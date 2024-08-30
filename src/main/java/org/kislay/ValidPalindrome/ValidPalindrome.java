package org.kislay.ValidPalindrome;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int endPointer = s.length() - 1;
        int startPointer = 0;
        boolean isPalindrome = true;
        while (endPointer > startPointer) {
            endPointer = getEndPointerPosition(endPointer, s);
            startPointer = getStartPointerPosition(startPointer, s, s.length() - 1);
            if (endPointer < startPointer) {
                break;
            }
            char endChar = s.charAt(endPointer);
            char startChar = s.charAt(startPointer);
            if (endChar != startChar) {
                isPalindrome = false;
                break;
            }
            endPointer --;
            startPointer ++;
        }
        return isPalindrome;
    }

    private int getEndPointerPosition(int currEndPointer, String s) {
        while (currEndPointer > 0 && !isAlphanumeric(s.charAt(currEndPointer))) {
            currEndPointer--;
        }
        return currEndPointer;
    }
    private int getStartPointerPosition(int curStartPointer, String s, int maxStartPointer) {
        while (curStartPointer < maxStartPointer && !isAlphanumeric(s.charAt(curStartPointer))) {
            curStartPointer++;
        }
        return curStartPointer;
    }

    private boolean isAlphanumeric(char ch) {
        return isAlphabet(ch) || isNum(ch);
    }

    private boolean isAlphabet(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        validPalindrome.isPalindrome("0P");
    }

}
