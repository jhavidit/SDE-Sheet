package array.day1;

public class KadanesAlgorithm {

    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int max_end_here = 0;
        for (int i = 0; i < nums.length; i++) {
            max_end_here += nums[i];
            if (max_end_here > max_so_far)
                max_so_far = max_end_here;
            if (max_end_here < 0)
                max_end_here = 0;
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        KadanesAlgorithm obj = new KadanesAlgorithm();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(obj.maxSubArray(arr));
    }

}
