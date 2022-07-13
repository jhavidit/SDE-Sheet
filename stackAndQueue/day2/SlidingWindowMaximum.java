package stackAndQueue.day2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {

            if (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                arr[index++] = nums[deque.peek()];
            }

        }
        return arr;
    }


    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(obj.maxSlidingWindow(arr, 3)));
    }
}
