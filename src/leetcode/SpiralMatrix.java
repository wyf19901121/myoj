package leetcode;

import java.util.ArrayList;

public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer> ();
        if (matrix.length == 0) {
            return res;
        }
        for (int i = 0; i < (Math.min(matrix.length, matrix[0].length)+1)/2; i++) {
            for (int j = i ; j < matrix[0].length-i; j++) {
                res.add(matrix[i][j]);
            }
            if (i+1 > matrix.length/2) {
                break;
            }
            for (int j = i+1; j < matrix.length-i; j++) {
                res.add(matrix[j][matrix[0].length-i-1]);
            }
            if (matrix[0].length-i-2 == -1) {
                break;
            }
            for (int j = matrix[0].length-i-2; j > i-1; j--) {
                res.add(matrix[matrix.length-i-1][j]);
            }
            for (int j = matrix.length-i-2; j > i; j--) {
                res.add(matrix[j][i]);
            }
        }
        return res;
    }
}
