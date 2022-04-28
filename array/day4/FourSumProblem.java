package array.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSumProblem {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int l = j + 1, r = n - 1;
                while (l < r) {
                    if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        list.add(temp);
                        while (l < r && nums[l] == temp.get(2)) {
                            l++;
                        }
                        while (l < r && nums[r] == temp.get(3)) {
                            r--;
                        }
                    } else if (nums[i] + nums[j] + nums[l] + nums[r] < target) {
                        l++;
                    } else r--;
                }
                while (j + 1 < n && nums[j + 1] == nums[j]) {
                    j++;
                }
            }
            while (i + 1 < n && nums[i + 1] == nums[i]) {
                i++;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        FourSumProblem obj = new FourSumProblem();
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(obj.fourSum(arr, target));
    }

}
