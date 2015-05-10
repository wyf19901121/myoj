package leetcode;

import java.util.ArrayList;
import java.util.Set;

public class WordBreakII {
	public ArrayList<String> reStrings = new ArrayList<String>();
    public ArrayList<String> wordBreak(String s, Set<String> wordDict) {
    	if (s.length() == 0) {
			return reStrings;
		}
        boolean[][] contain = new boolean[s.length()][s.length()];
        for (int i = 0; i < contain.length; i++) {
			for (int j = i; j < contain.length; j++) {
				if (wordDict.contains(s.substring(i, j+1))) {
					contain[i][j] = true;
				}
			}
		}
        for (int i = 0; i < contain.length; i++) {
			if (contain[i][s.length() - 1]) {
				break;
			}
			if (i == s.length() - 1 && contain[i][s.length()-1] == false) {
				return reStrings;
			}
		}
        ArrayList<Integer> indexArrayList = new ArrayList<Integer>();
        for (int i = 0; i < contain.length; i++) {
			if (contain[0][i]) {
				indexArrayList.add(i);
				getnext(contain, i+1, s, indexArrayList, wordDict);
				indexArrayList.remove(indexArrayList.size() - 1);
			}
		}
        return reStrings;
    }
    public void getnext(boolean[][] contain, int start, String srcString, ArrayList<Integer> index, Set<String> wordDict) {
    	if (start == srcString.length()) {
			int left = 0;
			String result = "";
			for (int i = 0; i < index.size(); i++) {
				int k = index.get(i);
				result = result + srcString.substring(left, k+1) + " ";
				left = k + 1;
			}
			result = result.substring(0, result.length() - 1);
			reStrings.add(result);
			return ;
		}
		for (int i = start; i < srcString.length(); i++) {
			if (contain[start][i]) {
				index.add(i);
				getnext(contain, i+1, srcString, index, wordDict);
				index.remove(index.size() - 1);
			}
		}
		return ;
	}
}
