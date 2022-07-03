package stackAndQueue.day1;

import java.util.Stack;

public class ReverseStack {

    public void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, x);
        }
    }

    private void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, x);
        stack.push(temp);
    }

    public static void main(String[] args) {
        ReverseStack obj = new ReverseStack();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        obj.reverseStack(stack);
        System.out.println(stack);
    }

}
