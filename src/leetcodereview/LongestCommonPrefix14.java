/**
 * Created by wangyifan on 2018/1/24.
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuffer comPre = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    return comPre.toString();
                }
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return comPre.toString();
                }
            }
            comPre.append(strs[0].charAt(i));
        }
        return comPre.toString();
    }
}
