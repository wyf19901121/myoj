package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> letterIndex = new HashMap<>();
        int curStart = 0, longest = 0, curLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char curLetter = s.charAt(i);
            if (!letterIndex.containsKey(curLetter)
                    || letterIndex.get(curLetter) < curStart) {
                curLen++;
                letterIndex.put(curLetter, i);
            }
            else {
                int repeatIndex = letterIndex.get(curLetter);
                curStart = repeatIndex + 1;
                curLen = i - curStart + 1;
                letterIndex.put(curLetter, i);
            }
            
            if (curLen > longest) {
                longest = curLen;
            }
        }
        return longest;
    }
}
