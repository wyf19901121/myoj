package leetcode;

import java.util.ArrayList;

public class NQueens {
    public ArrayList<String[]> reStrings = new ArrayList<>();
    public ArrayList<String[]> solveNQueens(int n) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[0] = i;
            tryQueen(array, 1, n);
            array[0] = 0;
        }
        return reStrings;
    }
    public void tryQueen(int[] array, int row, int sum) {
        if (row == sum) {
            String[] oneReStrings = new String[sum];
            char[] oneline = new char[sum];
            for (int i = 0; i < oneReStrings.length; i++) {
                for (int j = 0; j < oneline.length; j++) {
                    oneline[j] = array[i] == j ? 'Q' : '.';
                }
                oneReStrings[i] = String.valueOf(oneline);
            }
            reStrings.add(oneReStrings);
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (checkarray(array, row, i)) {
                array[row] = i;
                tryQueen(array, row+1, sum);
                array[row] = 0;
            }
        }
    }
    public boolean checkarray(int[] array, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (array[i] == col) {
                return false;
            }
            if (i + array[i] == row + col || Math.abs(i - row) == Math.abs(array[i] - col)) {
                return false;
            }
        }
        return true;
    }
}
