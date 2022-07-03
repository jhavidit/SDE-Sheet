package stackAndQueue.day2;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {

    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr.get(i)) {
                stack.pop();
            }
            int a = arr.get(i);
            if (stack.isEmpty())
                arr.set(i, -1);
            else
                arr.set(i, stack.peek());
            stack.push(a);
        }
        return arr;
    }



}
