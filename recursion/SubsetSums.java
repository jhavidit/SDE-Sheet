package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetSums {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        subset(arr, 0, 0, ans);
        return ans;
    }

    void subset(ArrayList<Integer> arr, int sum, int k, ArrayList<Integer> ans) {
        if (k == arr.size()) {
            ans.add(sum);
            return;
        }
        subset(arr, sum, k + 1, ans);
        subset(arr, sum + arr.get(k), k + 1, ans);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 2, 1));
        SubsetSums obj = new SubsetSums();
        ArrayList<Integer> ans = obj.subsetSums(arr, arr.size());
        Collections.sort(ans);
        System.out.println(ans);
    }
}
