package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    public ArrayList<List<Integer>> permute(int[] num) {
        if (num == null || num.length == 0) {
            return result;
        }
        
        dfs(0, num);
        return result;
    }
    public void dfs(int i, int[] num) {
        if (i == num.length) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < num.length; j++) {
                tmp.add(num[j]);
            }
            result.add(tmp);
        }
        for (int j = i; j < num.length; j++) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            dfs(i+1, num);
            tmp = num[i];
            num[i] = num[j];
            num[j]= tmp;
        }
    }
}
