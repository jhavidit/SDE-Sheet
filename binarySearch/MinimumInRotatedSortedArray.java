package binarySearch;

public class MinimumInRotatedSortedArray {

    public static int findMin(int[] arr) {
        int min = arr[0];
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[low] < arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                }
                low = mid + 1;
            } else if (arr[low] == arr[mid]) {
                low++;
            } else {
                if (arr[mid] < min) {
                    min = arr[mid];
                }
                high = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {10,1,10,10,10};
        System.out.println(findMin(arr));
    }

}
