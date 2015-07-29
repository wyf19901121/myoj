package leetcode;

public class NQueensII {
    public int totalNQueens(int n) {
        int[] array = new int[n];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[0] = i;
            sum += tryQueen(array, 1, n);
            array[0] = 0;
        }
        return sum;
    }
    public int tryQueen(int[] array, int row, int count) {
        if (row == count) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (checkcol(array, row, i)) {
                array[row] = i;
                sum += tryQueen(array, row+1, count);
                array[row] = 0;
            }
        }
        return sum;
    }
    public boolean checkcol(int[] array, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (array[i] == col) {
                return false;
            }
        }
        for (int i = 0; i < row; i++) {
            if (array[i] + i == row + col || Math.abs(array[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
