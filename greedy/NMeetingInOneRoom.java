package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NMeetingInOneRoom {

    public static int maxMeetings(int[] start, int[] end, int n) {
        int[][] arr = new int[start.length][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);
        int count = 1;
        for (int[] it : arr) {
            System.out.println(Arrays.toString(it));
        }
        int i = 0, j = 1;
        while (j < n) {
            if (arr[i][1] < arr[j][0]) {
                count++;
                i = j;
                j = i + 1;
            } else
                j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] start = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
        int[] end = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};
        System.out.println(maxMeetings(start, end, start.length));

    }

}
