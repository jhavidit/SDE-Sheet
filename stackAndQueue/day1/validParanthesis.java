package stackAndQueue.day1;

import java.util.Stack;

public class validParanthesis {

    public static boolean isValid(String s) {
        int l = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                else if (ch == ')' && stack.peek() != '(') {
                    return false;
                } else if (ch == '}' && stack.peek() != '{') {
                    return false;
                } else if (ch == ']' && stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

}
