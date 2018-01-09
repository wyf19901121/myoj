/**
 * Created by wangyifan on 2018/1/9.
 */
public class StringtoInteger8 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] ch = str.trim().toCharArray();
        if (ch.length == 0) {
            return 0;
        }
        int index = 0;
        long value = 0;
        int siganl = 1;
        if (ch[0] == '-' || ch[0] == '+') {
            siganl = ch[index++] == '-' ? -1 : 1;
        }

        while (index < ch.length && ch[index] <= '9' && ch[index] >= '0') {
            value = value * 10 + ch[index++] - '0';
            if (value * siganl > Integer.MAX_VALUE || value * siganl < Integer.MIN_VALUE) {
                return siganl == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int)(value * siganl);
    }
}
