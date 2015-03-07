package leetcode;

import java.awt.List;
import java.util.ArrayList;

public class PalindromePartitioning {
	public ArrayList<List<String>> res = new ArrayList<List<String>>();
	public ArrayList<Integer> part = new ArrayList<Integer>();
    public List<List<String>> partition(String s) {
    	boolean resMatrix[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
        	resMatrix[i][i] = true;
        	for (int j = i + 1; j < s.length(); j++) {
        		resMatrix[i][j] = isPalin(s, i, j);
        	}
        }
        for (int i = 0; i < s.length(); i++) {
        	part.add(0);
        	subpartition(resMatrix, s, 0, i+1);
        	part.remove(part.size()-1);
        }
        return res;
    }
    public boolean isPalin(String str, int start, int end) {
    	while(end > start) {
    		if (str.charAt(start) != str.charAt(end)) {
    			return false;
    		}
    		start++;
    		end--;
    	}
    	return true;
    }
    public void subpartition(boolean resMatrix[][], String str, int start, int end) {
    	if (resMatrix[start][end-1] == true) {
    	    if (end == str.length()) {
    	        ArrayList<String> ele = new ArrayList<String> ();
        		for (int i = 0; i < part.size()-1; i++) {
        			ele.add(str.substring(part.get(i), part.get(i+1)));
        		}
        		ele.add(str.substring(start, end));
        		res.add(ele);
        		return ;
    	    }
    		for (int i = end; i < str.length(); i++) {
    		    part.add(end);
    			subpartition(resMatrix, str, end, i+1);
    			part.remove(part.size()-1);
    		}
    	}
    	else {
    		return ;
    	}
    }
}
