package stackAndQueue.day1;

import java.awt.peer.ScrollbarPeer;
import java.util.Stack;

public class SortAStack {

    public void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            insertSortedOrder(stack, x);
        }
    }

    public void insertSortedOrder(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || x > stack.peek()) {
            stack.push(x);
            return;
        }
        int temp = stack.pop();
        insertSortedOrder(stack, x);
        stack.push(temp);
    }

    public static void main(String[] args) {
        SortAStack obj = new SortAStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(-1);
        stack.push(3);
        obj.sortStack(stack);
        System.out.println(stack);
    }

}
