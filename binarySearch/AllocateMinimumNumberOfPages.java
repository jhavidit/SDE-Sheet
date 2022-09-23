package binarySearch;

public class AllocateMinimumNumberOfPages {

    public static long allocateMinimumNumberOfPages(int n, int m, int[] time) {

        long low = time[0];
        long high = 0;
        for (int j : time) {
            low = Math.min(low, j);
            high += j;
        }
        while (low <= high) {
            long mid = (low + high) / 2;
            if (check(time, mid, n)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean check(int[] time, long mid, int m) {
        int count = 0;
        long last =0;
        for (int j : time) {
            if (last + j > mid) {
                count++;
                last = j;
                if (last > mid)
                    return false;
            } else {
                last += j;
            }
        }
        return count < m;
    }
}
