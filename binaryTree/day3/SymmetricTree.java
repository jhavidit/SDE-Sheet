package binaryTree.day3;

import sun.reflect.generics.tree.Tree;

public class SymmetricTree {

    TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        boolean[] arr = new boolean[1];
        arr[0] = true;
        checkSymmetric(root.left, root.right, arr);
        return arr[0];
    }

    public void checkSymmetric(TreeNode p, TreeNode q, boolean[] arr) {
        if (p == null && q == null) {
            return;
        }
        if (p == null || q == null) {
            arr[0] = false;
            return;
        }
        if (p.val != q.val){
            arr[0] = false;
            return;
        }

        checkSymmetric(p.left, q.right, arr);
        checkSymmetric(p.right, q.left, arr);
    }

    public static void main(String[] args) {
        SymmetricTree obj = new SymmetricTree();
        obj.root = new TreeNode(2);
        obj.root.left = new TreeNode(3);
        obj.root.right = new TreeNode(3);
        obj.root.left.left = new TreeNode(4);
        obj.root.left.right = new TreeNode(5);
        obj.root.right.left = new TreeNode(5);
        System.out.println(obj.isSymmetric(obj.root));
    }


}
