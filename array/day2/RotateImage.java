package array.day2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int left = 0, right = n - 1;
        while (left < right) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
        }

        for (int[] it : matrix) {
            System.out.println(Arrays.toString(it));
        }
    }

    public static void main(String[] args) {
        RotateImage obj = new RotateImage();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        obj.rotate(matrix);
    }

}
