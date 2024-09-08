package org.kislay;

import java.util.Stack;

class MinStack {

    Stack<Integer> elementStack;
    Stack<Integer> minStack;

    public MinStack() {
        this.elementStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        if (elementStack.isEmpty()) {
            elementStack.push(val);
            minStack.push(val);
        } else {
            int oldMin = this.getMin();
            minStack.push(Math.min(oldMin, val));
            elementStack.push(val);
        }
    }

    public void pop() {
        elementStack.pop();
        minStack.pop();
    }

    public int top() {
        return elementStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
