package stackAndQueue.day1;

import java.util.Stack;

public class ImplementQueueUsingStack {
    Stack<Integer> stack;

    public ImplementQueueUsingStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        stack.push(x);
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

}

class ImplementQueueUsingSingleStack {

    Stack<Integer> stack;

    public ImplementQueueUsingSingleStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int val = stack.pop();
        push(x);
        stack.push(val);
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

}
