package binaryTree.day3;

public class MaxPathSum {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] arr = new int[1];
        arr[0] = Integer.MIN_VALUE; // when answer is negative
        maxPathSum(root, arr);
        return arr[0];
    }

    int maxPathSum(TreeNode root, int[] arr) {
        if (root == null)
            return 0;
        int left = Math.max(0, maxPathSum(root.left, arr)); //eliminating negative path
        int right = Math.max(0, maxPathSum(root.right, arr));// eliminating negative path
        arr[0] = Math.max(arr[0], left + right + root.val);
        return root.val + Math.max(left, right);
    }

}
