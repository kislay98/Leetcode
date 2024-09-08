package org.kislay.BackSpaceCompare;

import java.util.Stack;

class BackSpaceCompare {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = constructStack(s);
        Stack<Character> stackT = constructStack(t);
        return stackS.equals(stackT);
    }

    private Stack<Character> constructStack(String s) {
        Integer n = s.length();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        BackSpaceCompare compare = new BackSpaceCompare();
        System.out.println(compare.backspaceCompare("abcd", "abcd"));
        System.out.println(compare.backspaceCompare("ab##", "c#d#"));
        System.out.println(compare.backspaceCompare("a#c", "b"));
    }

}
