package practice;

import java.util.Arrays;


public class OutOfBoundaryPaths {


    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        for (int[][] it : dp) {
            for (int[] i : it) {
                Arrays.fill(i, -1);
            }
        }
        return findPathsMemoization(m, n, maxMove, startRow, startColumn, dp)%mod;

    }

    public int findPathsMemoization(int m, int n, int maxMove, int i, int j, int[][][] dp) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 1%mod;
        if (maxMove == 0)
            return 0%mod;
        if (dp[i][j][maxMove] != -1) return dp[i][j][maxMove];
        int left = findPathsMemoization(m, n, maxMove - 1, i - 1, j, dp);
        int right = findPathsMemoization(m, n, maxMove - 1, i + 1, j, dp);
        int top = findPathsMemoization(m, n, maxMove - 1, i, j + 1, dp);
        int bottom = findPathsMemoization(m, n, maxMove - 1, i, j - 1, dp);
        return (left + right + top + bottom)%mod;

    }

    public static void main(String[] args) {
        OutOfBoundaryPaths obj = new OutOfBoundaryPaths();
        System.out.println(obj.findPaths(2, 2, 2, 0, 0));
    }


    private static final int mod = 1000000007;
}
