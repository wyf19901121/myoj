package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	int longest = 0, start = 0;
    	HashMap<Character, Integer> posHashMap = new HashMap<Character, Integer>();
    	for (int i = 0; i < s.length(); i++) {
    		if (!posHashMap.containsKey(s.charAt(i))) {
    			if (i - start + 1 > longest) {
    				longest = i - start + 1;
    			}
    		}
    		else {
    			if (posHashMap.get(s.charAt(i)) >= start) {
					if (i - start > longest) {
						longest = i - start;
					}
					start = posHashMap.get(s.charAt(i)) + 1;
				}
    			else {
					if (i - start + 1 > longest)
						longest = i - start + 1;
				}
    		}
			posHashMap.put(s.charAt(i), i);
    	}
    	return longest;
	}
}
