package practice;

import java.util.Arrays;

public class JumpGame2 {

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return jumpMemoization(nums, 0, dp);
    }

    public int jumpMemoization(int[] nums, int index, int[] dp) {
        if (index >= nums.length - 1)
            return 0;
        if (dp[index] != -1) return dp[index];
        int jump = (int) 1e9;
        for (int i = 1; i <= nums[index]; i++) {
            jump = Math.min(jumpMemoization(nums, index + i, dp) + 1, jump);
        }
        return dp[index] = jump;
    }


    public int jumpTabulation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int jump = (int) 1e9;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < n) {
                    jump = Math.min(jump, dp[i + j] + 1);
                }
            }
            dp[i] = jump;
        }
        return dp[0];
    }

    public int jumpBest(int[] nums) {
        int jumps = 0, currFarthest = 0, currEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = currFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGame2 obj = new JumpGame2();
        int[] jump = {2, 3, 1, 1, 4};
        System.out.println(obj.jump(jump));
        System.out.println(obj.jumpTabulation(jump));
    }

}
