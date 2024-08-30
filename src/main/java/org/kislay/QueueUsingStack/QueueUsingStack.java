package org.kislay.QueueUsingStack;

import java.util.Stack;

public class QueueUsingStack {

    static class MyQueue {

        private Stack<Integer> firstStack;
        private Stack<Integer> secondStack;

        public MyQueue() {
            this.firstStack = new Stack<>();
            this.secondStack = new Stack<>();
        }

        public void push(int x) {
            if (firstStack.isEmpty()) {
                firstStack.push(x);
            } else {
                while (!secondStack.isEmpty()) {
                    firstStack.push(secondStack.pop());
                }
                secondStack.push(x);
                while (!firstStack.isEmpty()) {
                    secondStack.push(firstStack.pop());
                }
                if (!secondStack.isEmpty()) {
                    firstStack.push(secondStack.pop());
                }
            }
        }

        public int pop() {
            Integer poppedNum = firstStack.pop();
            if (!secondStack.isEmpty()) {
                firstStack.push(secondStack.pop());
            }
            return poppedNum;
        }

        public int peek() {
            return firstStack.peek();

        }

        public boolean empty() {
            return firstStack.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

}
