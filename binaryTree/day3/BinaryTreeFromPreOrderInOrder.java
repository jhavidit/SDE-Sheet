package binaryTree.day3;

import java.util.HashMap;

public class BinaryTreeFromPreOrderInOrder {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            hm.put(inorder[i], i);
        }
        return buildTree(hm, 0, n - 1, preorder, 0, n - 1, inorder);
    }

    public TreeNode buildTree(HashMap<Integer, Integer> hm, int preStart, int preEnd, int[] preorder, int inStart, int inEnd, int[] inorder) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = hm.get(root.val);
        int numLeft = index - inStart;
        root.left = buildTree(hm, preStart + 1, preStart + numLeft, preorder, inStart, index - 1, inorder);
        root.right = buildTree(hm, preStart + numLeft + 1, preEnd, preorder, index + 1, inEnd, inorder);
        return root;
    }

}
