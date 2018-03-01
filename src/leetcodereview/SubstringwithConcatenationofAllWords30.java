import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangyifan on 2018/2/28.
 */
public class SubstringwithConcatenationofAllWords30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (dic.containsKey(words[i])) {
                dic.put(words[i], dic.get(words[i]) + 1);
            }
            else {
                dic.put(words[i], 1);
            }
        }
        int len = words[0].length();
        for (int i = 0; i < len; i++) {
            int count = 0;
            Map<String, Integer> cur = new HashMap<>();
            for (int start = i, end = i; end <= s.length() - len; end += len) {
                String curStr = s.substring(end, end + len);
                if (!dic.containsKey(curStr)) {
                    start = end + len;
                    cur.clear();
                    count = 0;
                    continue;
                }
                if (!cur.containsKey(curStr)) {
                    cur.put(curStr, 1);
                }
                else {
                    cur.put(curStr, cur.get(curStr) + 1);
                }
                count++;
                if (cur.get(curStr) > dic.get(curStr)) {
                    for (int j = start;; j += len) {
                        String delStr = s.substring(j, j + len);
                        cur.put(delStr, cur.get(delStr) - 1);
                        count--;
                        if (delStr.equals(curStr)) {
                            start = j + len;
                            break;
                        }
                    }
                }

                if (count == words.length) {
                    res.add(start);
                }
            }
        }
        return res;
    }
}
