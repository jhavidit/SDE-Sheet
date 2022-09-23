package practice;

import java.util.Arrays;

public class KInversePairArray {

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n][k + 1];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return KInversePairsMemoization(n - 1, k,dp);
    }

    public int KInversePairsMemoization(int n, int k,int[][] dp) {
        if (k == 0)
            return 1;
        if(n==0)
            return 0;
        if (dp[n][k]!=-1) return dp[n][k];
        int pick = KInversePairsMemoization(n - 1, k - 1,dp);
        int notPick = KInversePairsMemoization(n - 1, k,dp);
        return dp[n][k] = pick + notPick;
    }

    public static void main(String[] args){
        KInversePairArray obj = new KInversePairArray();
        System.out.println(obj.kInversePairs(3,0));
    }

}
