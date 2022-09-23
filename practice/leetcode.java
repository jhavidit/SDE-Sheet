package practice;

import java.util.*;

public class leetcode {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        int[] result = {0};
        path(root,targetSum,0,result);
        return result[0];
    }

    public void path(TreeNode root, int targetSum, int sum, int[] result) {
        if (root != null) {
            sum += root.val;
            if (sum == targetSum)
                result[0]++;
            path(root.left, targetSum, sum, result);
            path(root.right, targetSum, sum, result);
        }
    }

    public static void main(String[] args){

    }


}
