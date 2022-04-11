package array.day1;

import java.util.Arrays;
import java.util.HashSet;

public class SetMatrixZero {

    // Brute Force
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        if (matrix[i][k] != 0)
                            matrix[i][k] = -1;
                    }
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][j] != 0)
                            matrix[k][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }
    }
    // TC - O(N*M*(N+M))+O(N*M) SC - O(1)

    //Better Time Complexity
    public void setZeroesBetter(int[][] arr) {
        HashSet<Integer> hsr = new HashSet<>();
        HashSet<Integer> hsc = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    hsr.add(i);
                    hsc.add(j);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (hsr.contains(i) || hsc.contains(j)) {
                    arr[i][j] = 0;
                }
            }
        }
    }
    // TC - O(n*m)+o(n*m) SC - O(N+M)

    //Best Approach
    public static void setZeroesBetterSpaceOptimize(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstColumn = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) firstColumn = true;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }

        }
        for(int[] it:matrix){
            System.out.println(Arrays.toString(it));
        }
        System.out.println(firstColumn);
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }

            }
            if (firstColumn)
                matrix[i][0] = 0;
        }
    }
    // TC - O(N*M)+O(N*M)  SC - O(1)

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroesBetterSpaceOptimize(arr);
        for(int[] it:arr){
            System.out.println(Arrays.toString(it));
        }
    }

}
