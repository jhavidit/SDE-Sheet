package array.day1;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int a = nums.length - 2;
        int r = nums.length - 1;
        int l = a;
        while (l >= 0) {
            if (r <= l) {
                l = --a;
                r = nums.length - 1;
            } else if (nums[l] < nums[r]) {
                System.out.println(l + " " + r);
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                reverse(nums, l + 1);
                return;
            } else if (nums[l] >= nums[r]) {
                r--;
            }
        }
        reverse(nums, 0);
    }

    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        int[] arr = {1, 3, 2};
        obj.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void reverse(int[] arr, int l) {
        int r = arr.length - 1;
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }
}
