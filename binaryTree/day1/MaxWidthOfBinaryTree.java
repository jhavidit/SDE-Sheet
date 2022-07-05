package binaryTree.day1;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        TreeNode root;
        int value;

        Pair(TreeNode root, int value) {
            this.root = root;
            this.value = value;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int maxWidth = 1;
        Deque<Pair> deque = new LinkedList<>();
        deque.add(new Pair(root, 1));
        while (!deque.isEmpty()) {
            int size = deque.size();
            Pair firstNode = deque.getFirst();
            Pair lastNode = deque.getLast();
            maxWidth = Math.max(maxWidth, lastNode.value - firstNode.value + 1);
            for (int i = 0; i < size; i++) {
                Pair pair = deque.poll();
                if (pair.root.left != null) {
                    deque.add(new Pair(pair.root.left, 2 * pair.value + 1));
                }
                if (pair.root.right != null) {
                    deque.add(new Pair(pair.root.right, 2 * pair.value + 2));
                }
            }
        }
        return maxWidth;
    }

}
