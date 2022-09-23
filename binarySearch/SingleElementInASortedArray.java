package binarySearch;

public class SingleElementInASortedArray {

    public static int singleElement(int[] arr) {
        int low = 0, high = arr.length - 2;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (middle % 2 == 0) {
                if (arr[middle] != arr[middle + 1] && middle > 0 && arr[middle - 1] != arr[middle])
                    return arr[middle];
                else if (arr[middle] != arr[middle + 1]) {
                    high = middle - 1;
                } else
                    low = middle + 1;
            } else {
                if (arr[middle] == arr[middle + 1]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4,5,5};
        System.out.println(singleElement(arr));
    }

}
