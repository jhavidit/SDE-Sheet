package binaryTree.day3;

import java.util.Stack;

public class FlattenBinaryTreeIntoLInkedList {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }


    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (!stack.isEmpty()) {
                node.right = stack.peek();
            } else {

                node.right = null;
            }
            node.left = null;
        }
    }

    public void flattenBetter(TreeNode root) {
        if (root == null)
            return;
        TreeNode prev;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                prev = root.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

}
