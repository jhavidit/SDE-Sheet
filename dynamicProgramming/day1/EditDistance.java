package dynamicProgramming.day1;

import java.util.Arrays;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1][n2];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return minDistanceMemoization(word1, word2, n1 - 1, n2 - 1, dp);
    }

    public int minDistanceMemoization(String word1, String word2, int i, int j, int[][] dp) {
        if (j < 0) {
            if (i >= 0)
                return i + 1;
            else
                return 0;
        }
        if (i < 0)
            return j + 1;
        if (word1.charAt(i) == word2.charAt(j)) {
            return minDistanceMemoization(word1, word2, i - 1, j - 1, dp);
        } else {
            int insert = minDistanceMemoization(word1, word2, i - 1, j, dp);
            int delete = minDistanceMemoization(word1, word2, i, j - 1, dp);
            int replace = minDistanceMemoization(word1, word2, i - 1, j - 1, dp);
            return 1 + Math.min(insert, Math.min(delete, replace));
        }
    }

    public static void main(String[] args) {
        EditDistance obj = new EditDistance();
        System.out.println(obj.minDistance("horse", "ros"));
    }

}
