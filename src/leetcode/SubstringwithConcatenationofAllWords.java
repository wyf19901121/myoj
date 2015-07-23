package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
    	if (s == null || s.isEmpty() || words == null || words.length == 0) {
			return new ArrayList<Integer>();
		}
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	HashMap<String, Integer> dic = new HashMap<String, Integer>();
    	for (int i = 0; i < words.length; i++) {
    		String key = words[i];
			if (dic.containsKey(key)) {
				dic.put(key, dic.get(key)+1);
			}
			else {
				dic.put(key, 1);
			}
		}
    	int wordLen = words[0].length();
    	for (int i = 0; i < wordLen; i++) {
    		int count = 0;
    		HashMap<String, Integer> cur = new HashMap<String, Integer>();
    		for (int start = i, end = i; end <= s.length() - wordLen; end+=wordLen) {
    			String curStr = s.substring(end, end + wordLen);
				if (dic.containsKey(curStr)) {
					if (!cur.containsKey(curStr)) {
						cur.put(curStr, 1);
					}
					else {
						int curNum = cur.get(curStr);
						cur.put(curStr, curNum + 1);
					}
					if (cur.get(curStr) <= dic.get(curStr)) {
						count++;
					}
					else {
						for (int j = start;; j+=wordLen) {
							String delStr = s.substring(j, j+wordLen);
							int cnt = cur.get(delStr);
							cur.put(delStr, cnt - 1);
							if (delStr.equals(curStr)) {
								start = j + wordLen;
								break;
							}
							count--;
						}
					}
					if (count == words.length) {
						res.add(start);
					}
				}
				else {
					start = end + wordLen;
					count = 0;
					cur.clear();
				}
			}
		}
    	return res;
    }
}
