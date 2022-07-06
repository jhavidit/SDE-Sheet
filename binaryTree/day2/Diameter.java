package binaryTree.day2;

public class Diameter {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] arr = new int[1];
        maxDepth(root, arr);
        return arr[0];
    }


    public int maxDepth(TreeNode root, int[] arr) {
        if (root == null)
            return 0;
        else {
            int left = maxDepth(root.left, arr);
            int right = maxDepth(root.right, arr);
            arr[0] = Math.max(arr[0], left + right);
            return 1 + Math.max(left, right);
        }
    }

}
