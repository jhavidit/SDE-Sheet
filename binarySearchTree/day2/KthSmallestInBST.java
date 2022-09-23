package binarySearchTree.day2;

import java.util.ArrayList;

public class KthSmallestInBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] i = new int[2];
        i[0] = k;
        kthSmallest(root, k, arr, i);
        return i[1];
    }

    public void kthSmallest(TreeNode root, int k, ArrayList<Integer> arr, int[] i) {
        if (root != null && i[0] > 0) {
            kthSmallest(root.left, k, arr, i);
            i[0]++;
            i[1] = root.val;
            kthSmallest(root.right, k, arr, i);
        }
    }

    public static void main(String[] args) {

    }

}
