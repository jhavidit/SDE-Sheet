package dynamicProgramming.day1;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return lengthOfLISMemoization(nums, -1, 0, dp);
    }

    public int lengthOfLISMemoization(int[] nums, int prev, int i, int[][] dp) {
        if (i == nums.length)
            return 0;
        if (dp[i][prev+1] != -1) return dp[i][prev+1];
        int length = lengthOfLISMemoization(nums, prev, i + 1, dp);
        if (prev == -1 || nums[i] > nums[prev]) {
            length = Math.max(length, 1 + lengthOfLISMemoization(nums, i, i + 1, dp));
        }
        return dp[i][prev+1] = length;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(obj.lengthOfLIS(arr));
    }

}
