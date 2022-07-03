package stackAndQueue;


import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                hm.put(nums2[i], -1);
            } else {
                hm.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hm.get(nums1[i]);
        }
        return nums1;
    }

    //circular array
    public int[] nextGreaterElement2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            if (i < n) {
                if (stack.isEmpty()) {
                    arr[i] = -1;
                } else {
                    arr[i] = stack.peek();
                }
            }
            stack.push(nums[i % n]);
        }
        return arr;
    }
}
