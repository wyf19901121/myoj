/**
 * Created by wangyifan on 2018/1/5.
 */
public class ZigZagConversion6 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        char[] str = s.toCharArray();
        char[] zStr = new char[str.length];
        int index = 0;
        for (int i = 0; i < numRows && i < str.length; i++) {
            for (int j = i; j < str.length; j += 2*numRows-2) {
                if (i == 0 || i == numRows-1 || j+2*numRows-2-2*i >= str.length) {
                    zStr[index++] = str[j];
                }
                else {
                    zStr[index++] = str[j];
                    zStr[index++] = str[j+2*numRows-2-2*i];
                }
            }
        }
        return new String(zStr);
    }
}
