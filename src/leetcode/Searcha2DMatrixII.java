package leetcode;

public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int top = 0, right = matrix[0].length - 1;
        while (top < matrix.length && right >= 0) {
            if (matrix[top][right] == target) {
                return true;
            }
            if (matrix[top][right] < target) {
                top++;
            }
            else {
                right--;
            }
        }
        return false;
    }
}
