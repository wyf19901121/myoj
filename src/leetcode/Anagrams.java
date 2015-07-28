package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        Map<String, Integer> resMap = new HashMap<String, Integer> ();
        ArrayList<String> resArrayList = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
			char[] oldStr = strs[i].toCharArray();
			char[] newStr = new char [oldStr.length];
			System.arraycopy(oldStr, 0, newStr, 0, oldStr.length);
			Arrays.sort(newStr);
			String str = String.valueOf(newStr);
			if (resMap.containsKey(str)) {
				if (resMap.get(str) != -1) {
					resArrayList.add(strs[resMap.get(str)]);
					resMap.put(str, -1);
				}
				resArrayList.add(strs[i]);
			}
			else {
				resMap.put(str, i);
			}
		}
        return resArrayList;
    }
}
