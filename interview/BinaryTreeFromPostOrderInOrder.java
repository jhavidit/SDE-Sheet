package interview;

import java.util.HashMap;

public class BinaryTreeFromPostOrderInOrder {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, 0, n - 1, 0, n - 1, postorder, inorder);

    }

    public TreeNode buildTree(HashMap<Integer, Integer> map, int postStart, int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = map.get(root.val);
        int numPos = index - inStart;
        root.left = buildTree(map, postStart, postStart + numPos - 1, inStart, index - 1, postorder, inorder);
        root.right = buildTree(map, postStart + numPos, postEnd - 1, index + 1, inEnd, postorder, inorder);
        return root;

    }

}
