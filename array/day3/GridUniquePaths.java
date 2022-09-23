package array.day3;

import java.util.Arrays;

public class GridUniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return uniquePathMemoization(m - 1, n - 1, dp);
    }

    int uniquePathMemoization(int m, int n, int[][] dp) {
        if (m == 0 && n == 0)
            return 1;
        if (m < 0 || n < 0)
            return 0;
        if (dp[m][n] != -1) return dp[m][n];
        int top = uniquePathMemoization(m - 1, n, dp);
        int left = uniquePathMemoization(m, n - 1, dp);
        return dp[m][n] = top + left;
    }

    public int uniquePathTabulation(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int left = 0, up = 0;
                if (i > 0)
                    left = dp[i - 1][j];
                if (j > 0) {
                    up = dp[i][j - 1];
                }
                dp[i][j] = left + up;
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsSpaceOptimization(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            temp[0] = 1;
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int left = 0, up = 0;
                if (i > 0)
                    left = dp[j];
                if (j > 0) {
                    up = temp[j - 1];
                }
                temp[j] = left + up;
            }
            dp = temp;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        GridUniquePaths obj = new GridUniquePaths();
        System.out.println(obj.uniquePaths(3, 2));
        System.out.println(obj.uniquePathTabulation(3, 7));
        System.out.println(obj.uniquePathsSpaceOptimization(3, 7));
    }

}
