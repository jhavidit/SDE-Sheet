package practice;

import jdk.nashorn.internal.ir.SplitReturn;

import java.util.Arrays;

public class DecodeWays {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecodingMemoization(s, 0, dp);
    }

    public int numDecodingMemoization(String str, int ind, int[] dp) {
        if (ind == str.length())
            return 1;
        if (str.charAt(ind) == '0') return 0;
        if (dp[ind] != -1) return dp[ind];
        int one = numDecodingMemoization(str, ind + 1, dp);
        if (ind < (str.length() - 1) && (str.charAt(ind) == '1' || str.charAt(ind) == '2' && str.charAt(ind + 1) < '7')) {
            one += numDecodingMemoization(str, ind + 2, dp);
        }
        return dp[ind] = one;
    }

    public int numDecodingTabulation(String str) {
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) != '0') {
                int one = dp[i + 1];
                if (i < n - 1 && (str.charAt(i) == '1' || str.charAt(i) == '2' && str.charAt(i + 1) < '7')) {
                    one += dp[i + 2];
                }
                dp[i] = one;
            }
        }
        return dp[0];
    }

    public int numDecodingSpaceOptimization(String str) {
        int n = str.length();
        int last = 1;
        int secondLast = 0;
        for (int i = n - 1; i >= 0; i--) {

                int one =  (str.charAt(i) == '0')?0:last;

                if (i < n - 1 && (str.charAt(i) == '1' || str.charAt(i) == '2' && str.charAt(i + 1) < '7')) {
                    one += secondLast;
                }
                secondLast = last;
                last = one;

        }
        return last;
    }

    public static void main(String[] args) {
        DecodeWays obj = new DecodeWays();
        System.out.println(obj.numDecodings("12"));
        System.out.println(obj.numDecodingTabulation("12"));
        System.out.println(obj.numDecodingSpaceOptimization("12"));
    }
}
