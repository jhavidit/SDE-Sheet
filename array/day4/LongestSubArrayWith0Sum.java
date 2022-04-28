package array.day4;

import java.util.HashMap;

public class LongestSubArrayWith0Sum {

    int maxLen(int[] arr, int n) {
        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0)
                max = i + 1;
            else {
                if (!hm.containsKey(sum)) {
                    hm.put(sum, i);
                } else {
                    max = Math.max(max, i - hm.get(sum));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubArrayWith0Sum obj = new LongestSubArrayWith0Sum();
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(obj.maxLen(arr, arr.length));
    }

}
