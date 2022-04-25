package array.day1;

import java.util.Arrays;

public class SortArrayOf012 {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1, m = 0;
        while (m <= r) {
            switch (nums[m]) {
                case 0: {
                    int temp = nums[l];
                    nums[l] = nums[m];
                    nums[m] = temp;
                    l++;
                    m++;
                    break;
                }
                case 1: {
                    m++;
                    break;
                }
                case 2: {
                    int temp = nums[r];
                    nums[r] = nums[m];
                    nums[m] = temp;
                    r--;
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {
        SortArrayOf012 obj = new SortArrayOf012();
        int[] arr = {1, 1, 2, 0, 0, 2, 1};
        obj.sortColors(arr);
        System.out.println(Arrays.toString(arr));

    }

}
