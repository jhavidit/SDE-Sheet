package binaryTree;

public class CheckHeightBalanced {

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

    public boolean isBalanced(TreeNode root) {
        boolean[] check = new boolean[1];
        check[0] = true;
        maxDepth(root,check);
        return check[0];
    }

    public int maxDepth(TreeNode root,boolean[] check){
        if(root==null)
            return 0;
        int left = maxDepth(root.left,check);
        int right = maxDepth(root.right,check);
        if(Math.abs(left-right)>1)
            check[0] = false;
        return 1 + Math.max(left,right);
    }

}
