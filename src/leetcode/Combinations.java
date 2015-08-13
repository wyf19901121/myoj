package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	List<List<Integer>> result = new ArrayList<List<Integer>> ();
	public List<List<Integer>> combine(int n, int k) {
		if (n < k) {
			return result;
		}
		int[] cb = new int[k];
		findcombine(cb, 0, 0, n, k);
		return result;
	}
	
	public void findcombine(int[] cb, int curNum, int curIndex, int n, int k) {
		if (curNum == k) {
			ArrayList<Integer> sigle = new ArrayList<Integer>(k);
			for (int i = 0; i < cb.length; i++) {
				sigle.add(cb[i]);
			}
			result.add(sigle);
			return ;
		}
		
		for (int i = curIndex; i <= n - k + curNum; i++) {
			cb[curNum] = i + 1;
			findcombine(cb, curNum+1, i+1, n, k);
		}
	}
}
