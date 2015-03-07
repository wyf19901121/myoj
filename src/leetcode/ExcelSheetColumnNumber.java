package leetcode;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += (s.charAt(s.length() - 1 - i) - 'A' + 1) * (int)Math.pow(26, i); 
        }
        return res;
    }
}
