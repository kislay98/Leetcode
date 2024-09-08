package org.kislay.ReversePolishNotation;

import java.util.List;
import java.util.Set;
import java.util.Stack;

class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> validOperators = Set.of("+", "-", "/", "*");
        for(String token: tokens) {
            if (validOperators.contains(token)) {
                String a = stack.pop();
                String b = stack.pop();
                stack.push(findResult(b, a, token));
            } else {
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.peek());
    }

    private String findResult(String a, String b, String token) {
        Integer aVal = Integer.valueOf(a);
        Integer bVal = Integer.valueOf(b);
        return switch (token) {
            case "+" -> String.valueOf(aVal + bVal);
            case "-" -> String.valueOf(aVal - bVal);
            case "*" -> String.valueOf(aVal * bVal);
            case "/" -> String.valueOf(aVal/bVal);
            default -> "";
        };
    }

}
