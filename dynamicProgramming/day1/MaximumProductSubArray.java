package dynamicProgramming.day1;

public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {
        int prod1 = nums[0], prod2 = nums[0], res = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int temp = Math.max(nums[i], Math.max(prod1 * nums[i], prod2 * nums[i]));
            prod2 = Math.min(nums[i], Math.min(prod1 * nums[i], prod2 * nums[i]));
            prod1 = temp;
            res = Math.max(res, prod1);
        }
        return res;
    }

}
