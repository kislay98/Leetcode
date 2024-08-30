package org.kislay.ValidParenthesis;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        boolean valid = true;
        int length = s.length();
        Map<Character, Character> validCharMap = Map.of('{', '}', '(', ')', '[', ']');
        List<Character> addToStack = List.of('{', '(', '[');
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < length; i++) {
            Character ch = s.charAt(i);
            if (addToStack.contains(ch)) {
                charStack.addElement(ch);
            } else {
                if (charStack.isEmpty()) {
                    valid = false;
                    break;
                }
                Character pop = charStack.pop();
                if (!ch.equals(validCharMap.get(pop))) {
                    valid = false;
                    break;
                }
            }
        }

        return valid && charStack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        validParenthesis.isValid("]");
    }
}
