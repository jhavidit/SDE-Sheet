package practice;

import java.util.Arrays;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (s1.length() + s2.length() != s3.length())
            return false;
        int[][] dp = new int[n1][n2];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return isInterleaveMemoization(s1, s2, s1.length() - 1, s2.length() - 1, s3, s3.length() - 1, dp);
    }

    public boolean isInterleaveMemoization(String s1, String s2, int i, int j, String s3, int k, int[][] dp) {
        if (k < 0 && i < 0 && j < 0) return true;

        if (i >= 0 && j >= 0 && dp[i][j] != -1) return dp[i][j] == 1;

        if (i >= 0 && j >= 0 && s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
            if (isInterleaveMemoization(s1, s2, i - 1, j, s3, k - 1, dp) ||
                    isInterleaveMemoization(s1, s2, i, j - 1, s3, k - 1, dp)) {
                dp[i][j] = 1;
                return true;
            } else {
                dp[i][j] = 0;
                return false;
            }

        }
        if (i >= 0 && s1.charAt(i) == s3.charAt(k)) {
            return isInterleaveMemoization(s1, s2, i - 1, j, s3, k - 1, dp);

        }
        if (j >= 0 && s2.charAt(j) == s3.charAt(k)) {
            return isInterleaveMemoization(s1, s2, i, j - 1, s3, k - 1, dp);

        }

        return false;
    }

    public boolean isInterleaveTabulation(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if(n1+n2!=n3)
            return false;
        int k = 0;
        boolean[][] dp = new boolean[n1][n2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                k = i+j;
                if(i==0 || j==0)
                    dp[i][j] = true;
              else  if (s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (s1.charAt(i) == s3.charAt(k)) {
                    dp[i][j] = dp[i - 1][j];
                } else if (s2.charAt(j) == s3.charAt(k)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }

            }
        }
        return dp[n1 - 1][n2 - 1];
    }

    public static void main(String[] args) {
        InterleavingString obj = new InterleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(obj.isInterleaveTabulation(s1, s2, s3));
    }

}
