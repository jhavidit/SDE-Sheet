package array.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        if (intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {

            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(start);
                l.add(end);
                list.add(l);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        List<Integer> l = new ArrayList<>();
        l.add(start);
        l.add(end);
        list.add(l);

        int[][] arr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            arr[i][0] = list.get(i).get(0);
            arr[i][1] = list.get(i).get(1);
        }
        return arr;
    }

    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] arr = obj.merge(intervals);
        for (int[] it : arr) {
            System.out.println(Arrays.toString(it));
        }
    }

}
