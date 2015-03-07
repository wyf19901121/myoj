package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        Map<String, Integer> resMap = new HashMap<String, Integer> ();
        ArrayList<String> resArrayList = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String key = transfer(strs[i]);
            if (!resMap.containsKey(key)) {
                resMap.put(key, i);
            }
            else {
                if (resMap.get(key) != -1) {
                    resArrayList.add(strs[i]);
                    resArrayList.add(strs[resMap.get(key)]);
                    resMap.put(key, -1);
                }
                else {
                    resArrayList.add(strs[i]);
                }
            }
        }
        return resArrayList;
    }
    public String transfer(String s) {
        StringBuilder t = new StringBuilder();  
        
        int[] count = new int[26];  
        for (int i = 0; i < s.length(); i++) {  
            count[s.charAt(i) - 'a']++;  
        }  
        for (int i = 0; i < count.length; i++) {  
            for (int j = 0; j < count[i]; j++) {  
                t.append((char) ('a' + i));  
            }  
        }  
          
        return t.toString(); 
    }
}
