package dynamicProgramming.day2;

import java.util.Arrays;

public class SubsetSum {

    public boolean canPartition(int[] nums) {
        int l = nums.length;
        int sum = 0;
        for (int it : nums) {
            sum += it;
        }
        if (sum % 2 != 0)
            return false;
        int[][] dp = new int[l][sum / 2 + 1];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return canPartitionMemoization(nums, l - 1, sum / 2, dp);
    }

    public boolean canPartitionMemoization(int[] nums, int i, int sum, int[][] dp) {
        if (i < 0)
            return sum == 0;
        if (dp[i][sum] != -1) return dp[i][sum] == 1;
        boolean pick = canPartitionMemoization(nums, i - 1, sum, dp);
        if (sum >= nums[i])
            pick = canPartitionMemoization(nums, i - 1, sum - nums[i], dp);
        boolean notPick = canPartitionMemoization(nums, i - 1, sum, dp);
        if (pick || notPick) {
            dp[i][sum] = 1;
            return true;
        } else {
            dp[i][sum] = 0;
            return false;
        }
    }

    public boolean canPartitionTabulation(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int it : nums) {
            sum += it;
        }
        if (sum % 2 == 1)
            return false;
        int k = sum / 2;
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= k) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean pick = dp[i - 1][k];
                if (j >= nums[i]) {
                    pick = dp[i - 1][j - nums[i]];
                }
                boolean notPick = dp[i - 1][j];
                dp[i][j] = pick || notPick;
            }
        }
        return dp[n - 1][k];
    }

    public boolean canPartitionSpaceOptimization(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int it : nums) {
            sum += it;
        }
        if (sum % 2 == 1)
            return false;
        int k = sum / 2;
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;
        dp[nums[0]] = true;
        for (int i = 1; i < n; i++) {
            boolean[] temp = new boolean[k + 1];
            temp[0] = true;
            for (int j = 1; j <= k; j++) {
                boolean pick = dp[k];
                if (j >= nums[i]) {
                    pick = dp[j - nums[i]];
                }
                boolean notPick = dp[j];
                temp[j] = pick || notPick;
            }
            dp = temp;
        }
        return dp[k];
    }


    public static void main(String[] args) {
        SubsetSum obj = new SubsetSum();
        int[] arr = {1, 2, 3, 5};
        int[] arr1 = {1, 5, 11, 5};
        System.out.println(obj.canPartitionSpaceOptimization(arr));
        System.out.println(obj.canPartitionSpaceOptimization(arr1));
    }


}
