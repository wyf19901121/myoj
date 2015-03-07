package leetcode;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        char[] res = new char [num1.length() + num2.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = '0';
        }
        int temp = 0;
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                if (num1.charAt(i) == '0' || num2.charAt(j) == '0') {
                    continue;
                }
                temp = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                setResult(i+j+1, temp, res);
            }
        }
        if (res[0] == '0') {
            return String.valueOf(res, 1, res.length-1);
        }
        return String.valueOf(res);
    }
    public void setResult(int pos, int src, char[] res) {
        while (src > 0) {
            src += res[pos] - '0';
            res[pos] = (char) ('0' + src%10);
            src /= 10;
            pos--;
        }
    }
}
