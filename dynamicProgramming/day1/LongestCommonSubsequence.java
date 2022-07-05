package dynamicProgramming.day1;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return longestCommonSubsequenceMemoization(text1, text2, n1 - 1, n2 - 1, dp);
    }

    public int longestCommonSubsequenceMemoization(String text1, String text2, int index1, int index2, int[][] dp) {
        if (index1 < 0 || index2 < 0)
            return 0;
        if (dp[index1][index2] != -1) return dp[index1][index2];
        if (text1.charAt(index1) == text2.charAt(index2))
            return dp[index1][index2] = 1 + longestCommonSubsequenceMemoization(text1, text2, index1 - 1, index2 - 1, dp);
        else
            return dp[index1][index2] = Math.max(longestCommonSubsequenceMemoization(text1, text2, index1 - 1, index2, dp),
                    longestCommonSubsequenceMemoization(text1, text2, index1, index2 - 1, dp));
    }

    public int longestCommonSubsequenceTabulation(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n1][n2];
    }

    public int longestCommonSubsequenceSpaceOptimization(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[] dp = new int[n2 + 1];
        for (int i = 0; i <= n1; i++) {
            int[] temp = new int[n2 + 1];
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    temp[j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    temp[j] = 1 + dp[j - 1];
                } else
                    temp[j] = Math.max(temp[j - 1], dp[j]);
            }
            dp = temp;
        }
        return dp[n2];
    }

}
