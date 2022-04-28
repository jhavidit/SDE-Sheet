package array.day4;

import java.util.HashSet;
import java.util.PriorityQueue;

public class LongestCommonSubsequence {

    public int longestConsecutive(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int it : nums) {
            pq.add(it);
        }

        int count = 1;
        int c = 0;
        int a = 0;

        if (!pq.isEmpty())
            a = pq.peek() - 1;

        while (!pq.isEmpty()) {
            int b = pq.poll();

            if (b - a == 1) {

                c++;
            } else if (b - a == 0) {

            } else {

                count = Math.max(c, count);
                c = 1;
            }
            a = b;
        }
        return Math.max(count, c);
    }

    public int longestConsecutiveBestApproach(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int it : nums) {
            hs.add(it);
        }
        int count = 1;
        int c = 1;
        for (int it : hs) {
            if (!hs.contains(it - 1)) {
                int i = it;
                while (hs.contains(++i)) {
                    c++;
                }

                count = Math.max(c, count);
            }

            c = 1;
        }
        return count;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(obj.longestConsecutive(arr));
        System.out.println(obj.longestConsecutiveBestApproach(arr));
    }

}
