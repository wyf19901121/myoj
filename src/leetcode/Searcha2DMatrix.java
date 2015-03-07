package leetcode;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rlen = matrix.length, clen = matrix[0].length, len = rlen * clen;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid/clen][mid%clen] < target) {
                left = mid + 1;
            }
            else if (matrix[mid/clen][mid%clen] > target) {
                right = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
