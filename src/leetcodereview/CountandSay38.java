/**
 * Created by wangyifan on 2018/4/18.
 */
public class CountandSay38 {
    public String countAndSay(int n) {
        StringBuffer str = new StringBuffer("1");
        for (int i = 2; i <= n; i++) {
            str = countAndSay(str);
        }
        return str.toString();
    }
    private StringBuffer countAndSay(StringBuffer str) {
        StringBuffer newStr = new StringBuffer(20);
        for (int i = 0; i < str.length(); i++) {
            int j = i + 1;
            while (j <= str.length()) {
                if (j == str.length() || str.charAt(j) != str.charAt(i)) {
                    newStr.append(String.valueOf(j - i));
                    newStr.append(str.charAt(i));
                    i = j - 1;
                    break;
                }
                j++;
            }
        }
        return newStr;
    }
}
