package dynamicProgramming.day1;

import java.util.Arrays;

public class ZeroOneKnapsack {

    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] dp = new int[l][m + 1][n + 1];
        for (int[][] it : dp) {
            for (int[] i : it) {
                Arrays.fill(i, -1);
            }
        }
        return findMaxFormMemoization(strs, l - 1, m, n, dp);
    }

    public int findMaxFormMemoization(String[] strs, int i, int m, int n, int[][][] dp) {
        if (i < 0)
            return 0;
        if (dp[i][m][n] != -1) return dp[i][m][n];
        int pick = findMaxFormMemoization(strs, i - 1, m, n, dp);
        int zero = calculateZero(strs[i]);
        int one = strs[i].length() - zero;
        if (zero <= m && one <= n) {
            pick = Math.max(pick, findMaxFormMemoization(strs, i - 1, m - zero, n - one, dp) + 1);
        }
        return dp[i][m][n] = pick;
    }

    public int calculateZero(String str) {
        int zero = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                zero++;
        }
        return zero;
    }

    public static void main(String[] args) {
        ZeroOneKnapsack obj = new ZeroOneKnapsack();
        String[] arr = {"00", "000"};
        System.out.println(obj.findMaxForm(arr,1,10));
    }

}
