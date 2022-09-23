package practice;

import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromicPath {

    int count = 0;

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] map = new int[10];
        calculatePath(root, map);
        return count;
    }

    void calculatePath(TreeNode root, int[] map) {
        if (root == null)
            return;
        map[root.val]++;
        if (root.left == null && root.right == null) {
            if (isPalindromic(map))
            count++;
        } else {
            calculatePath(root.left, map);
            calculatePath(root.right, map);

        }
        map[root.val]--;
    }

    public boolean isPalindromic(int[] map) {
        int c = 0;
        for (int j : map) {
            if (j % 2 != 0)
                c++;
        }
        return c <= 1;
    }


}
