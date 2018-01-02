import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyifan on 2018/1/2.
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int left = -1, max = 0;
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < str.length ; i++) {
            char rightLetter = str[i];
            if (index.containsKey(rightLetter) && index.get(rightLetter) > left) {
                left = index.get(rightLetter);
                index.put(rightLetter, i);
                max = Math.max(max, i - left);
            }
            else {
                index.put(rightLetter, i);
                max = Math.max(max, i - left);
            }
        }
        return str.length - left - 1 > max ? str.length - left - 1 : max;
    }
}
