package array.day3;

import java.util.ArrayList;
import java.util.List;

public class MajorityElements2 {
    public static List<Integer> majorityElement(int[] nums) {
        int nums1 = -1, nums2 = -1, c1 = 0, c2 = 0;
        List<Integer> list = new ArrayList<>();
        for (int it : nums) {
            if (it == nums1) {
                c1++;
            } else if (it == nums2) {
                c2++;
            } else if (c1 == 0) {
                nums1 = it;
                c1++;
            } else if (c2 == 0) {
                nums2 = it;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        int count1 = 0, count2 = 0;
        for (int it : nums) {
            if (it == nums1)
                count1++;
            else if (it == nums2)
                count2++;
        }
        if (count1 > (nums.length / 3)) {
            list.add(nums1);
        }
        if (count2 > (nums.length / 3)) {
            list.add(nums2);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9};
        System.out.println(majorityElement(arr));

    }

}
