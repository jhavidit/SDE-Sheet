package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        subset(arr, 0, ans, new ArrayList<>());
        return ans;
    }

    private void subset(int[] arr, int n, List<List<Integer>> ans, ArrayList<Integer> list) {
        ans.add(new ArrayList<>(list));
        for (int i = n; i < arr.length; i++) {
            if (i != n && arr[i - 1] == arr[i]) {
                continue;
            }
            list.add(arr[i]);
            subset(arr, i + 1, ans, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset2 obj = new Subset2();
        int[] arr = {0};
        List<List<Integer>> list = obj.subsetsWithDup(arr);
        System.out.println(list);
    }
}
