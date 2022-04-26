package array.day2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0)
            return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        for (int l = 0; l < m; l++) {
            if (nums1[l] > nums2[0]) {
                int temp = nums1[l];
                nums1[l] = nums2[0];
                nums2[0] = temp;

                for (int j = 0; j < n - 1; j++) {
                    if (nums2[j] > nums2[j + 1]) {
                        int t = nums2[j];
                        nums2[j] = nums2[j + 1];
                        nums2[j + 1] = t;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        System.out.println(Arrays.toString(nums1));
    }
    // TC - O(m*n) SC-O(1)

    public void mergeUsingGap(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        int gap = (int) Math.ceil((double) (m + n) / 2.0);
        while (gap != 0) {
            int i = 0;
            while (i + gap < nums1.length) {
                if (nums1[i] > nums1[i + gap]) {
                    int t = nums1[i];
                    nums1[i] = nums1[i + gap];
                    nums1[i + gap] = t;
                }
                i++;
            }
            if (gap == 1)
                return;
            gap = (int) Math.ceil((double) gap / 2.0);

        }
        System.out.println(Arrays.toString(nums1));
    }
    // TC - O(n*log(n)) SC- O(1)

    public static void main(String[] args) {
        MergeSortedArray obj = new MergeSortedArray();
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        obj.merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
        obj.mergeUsingGap(nums1, nums1.length - nums2.length, nums2, nums2.length);

    }

}
