package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    // we will use technique of picking and non picking from all indexes from array
    private void combination(int[] candidates, int target, int index, ArrayList<Integer> arr, List<List<Integer>> ans) {
        if (index == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(arr)); // when reached end of array and target is zero add to answer list
            }
            return;
        }
        if (candidates[index] <= target) { // base case will add only if array at current index contain value less or equal to required value
            arr.add(candidates[index]);
            combination(candidates, target - candidates[index], index, arr, ans); // when picked element we can again pick that element so not increasing index
            arr.remove(arr.size() - 1);
        }
        combination(candidates, target, index + 1, arr, ans); // not picking element and moving to next index

    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] arr = {2, 3, 6, 7};
        List<List<Integer>> list = obj.combinationSum(arr, 7);
        System.out.println(list);
    }


}
