package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    public ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        int[] temp = new int [S.length];
        for (int i = 0; i <= S.length; i++) {
            generateList(S, 0, 0, i, temp);
        }
        return res;
    }
    public void generateList(int[] src, int start, int curLength, int sumLength, int[] tempRes) {
        if (curLength == sumLength) {
            ArrayList<Integer> resList = new ArrayList<>();
            for (int i = 0; i < sumLength; i++) {
                resList.add(tempRes[i]);
            }
            res.add(resList);
            return ;
        }
        for (int i = start; i <= src.length - sumLength + curLength; i++) {
            tempRes[curLength] = src[i];
            generateList(src, i+1, curLength+1, sumLength, tempRes);
        }
        return ;
    }
}
