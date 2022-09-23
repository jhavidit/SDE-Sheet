package heap;

import java.util.Arrays;

public class HeapSort {

    public void heapify(int[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, largest, n);
        }
    }

    public void heap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    public void heapSort(int[] arr, int n) {
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        int[] arr = {5, 2, 4, 3, 1};
        obj.heap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        obj.heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
