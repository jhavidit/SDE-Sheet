package array.day3;

public class SearchInA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        int rc = matrix.length * matrix[0].length;
        int hi = rc - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (target == matrix[row][col])
                return true;
            else if (target < matrix[row][col]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

        }
        return false;
    }

}
