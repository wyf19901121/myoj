package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstringwithConcatenationofAllWords {
    public ArrayList<Integer> findSubstring(String S, ArrayList<String> L) {
        ArrayList<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0 || L == null || L.size() == 0) {
            return res;
        }
        HashMap<String, Integer> dic = new HashMap<>();
        for (int i = 0; i < L.size(); i++) {
            if(!dic.containsKey(L.get(i))) {
                dic.put(L.get(i), 1);
            }
            else {
                int count = dic.get(L.get(i));
                dic.put(L.get(i), count+1);
            }
        }
        int wordLen = L.get(0).length();
        for (int i = 0; i < wordLen; i++) {
            HashMap<String, Integer> cur = new HashMap<>();
            int count = 0;
            for (int begin = i, end = i; end <= S.length() - wordLen; end += wordLen) {
                String str = S.substring(end, end + wordLen);
                if (dic.containsKey(str)) {
                    if (!cur.containsKey(str)) {
                        cur.put(str, 1);
                    }
                    else {
                        int c = cur.get(str);
                        cur.put(str, c + 1);
                    }
                    if (cur.get(str) <= dic.get(str)) {
                        count++;
                    }
                    else {
                        for (int j = begin; ; j += wordLen) {
                            String srcString = S.substring(j, j + wordLen);
                            int cnt = cur.get(srcString);
                            cur.put(srcString, cnt - 1);
                            if (srcString.equals(str)) {
                                begin = j + wordLen;
                                break;
                            }
                            count--;
                        }
                    }
                    if (count == L.size()) {
                        res.add(begin);
                    }
                }
                else {
                    begin = end + wordLen;
                    cur.clear();
                    count = 0;
                }
            }
        }
        return res;
    }
}
