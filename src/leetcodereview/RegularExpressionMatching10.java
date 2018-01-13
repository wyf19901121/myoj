/**
 * Created by wangyifan on 2018/1/13.
 */
public class RegularExpressionMatching10 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return firstMatch && isMatch(s.substring(1), p)
                    || isMatch(s, p.substring(2));
        }
        else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
