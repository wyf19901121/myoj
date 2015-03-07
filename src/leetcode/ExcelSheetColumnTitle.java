package leetcode;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String res = "";
        while (n != 0) {
           if (n % 26 != 0) {
        	   res = (char)(n % 26 + 64) + res;
        	   n = n / 26;  
           }
           else {
        	   res = "Z" + res;
        	   n = n / 26 - 1;
           }
        }
        return res;
    }
}
