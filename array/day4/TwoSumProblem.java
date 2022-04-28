package array.day4;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumProblem {

    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(nums));
        int l = 0, r = nums.length - 1;
        int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE;
        while (l < r) {
            if (copy[l] + copy[r] == target) {
                num1 = copy[l];
                num2 = copy[r];
                break;
            } else if (copy[l] + copy[r] < target) {
                l++;
            } else r--;
        }
        System.out.println(num1 + "  " + num2);

        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == num1 || nums[i] == num2) {
                arr[0] = i;
                break;
            }
        }

        for (; i < nums.length; i++) {
            if (nums[i] == num2 || nums[i] == num1)
                arr[1] = i;
        }
        return arr;
    }

    public int[] twoSumUsingHashing(int[] nums, int target) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (h.containsKey(target - nums[i])) {
                return new int[]{h.get(target - nums[i]), i};
            }
            h.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumProblem obj = new TwoSumProblem();
        int[] arr = {-1, -2, -3, -4, -5};
        int target = -8;
        System.out.println(Arrays.toString(obj.twoSum(arr, target)));
    }
}
