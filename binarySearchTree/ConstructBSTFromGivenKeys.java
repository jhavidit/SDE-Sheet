package binarySearchTree;

public class ConstructBSTFromGivenKeys {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        public TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return AVLTree(nums,0,nums.length-1);
    }

    public TreeNode AVLTree(int[] nums,int left,int right){
        if(left<=right){
            int mid = (left+right)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = AVLTree(nums,left,mid-1);
            node.right = AVLTree(nums,mid+1,right);
            return node;
        }
        return null;
    }

}
