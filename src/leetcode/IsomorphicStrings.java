package leetcode;

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> elemnetmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (elemnetmap.containsKey(s.charAt(i)) && elemnetmap.get(s.charAt(i)) != t.charAt(i)
                     || elemnetmap.containsValue(t.charAt(i)) && !elemnetmap.containsKey(s.charAt(i))) {
                return false;
            }
            elemnetmap.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
