package greedy;


import java.util.Arrays;

public class MinimumNumberOfPlatforms {
    static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0;
        int max = 0, platform = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platform++;
                i++;
            } else {
                platform--;
                j++;
            }
            max = Math.max(max, platform);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dept = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dept, arr.length));
    }

}


