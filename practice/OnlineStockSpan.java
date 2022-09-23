package practice;

import java.util.Stack;

public class OnlineStockSpan {

    Stack<int[]> stack;

    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        if (stack.isEmpty() || stack.peek()[0] > price) {
            stack.push(new int[]{price, 1});
        } else {
            int x = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                x += stack.pop()[1];
            }
            stack.push(new int[]{price, x});
        }
        return stack.peek()[1];
    }

}
