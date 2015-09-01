package leetcode;

public class IntegertoEnglishWords {
    private String nums[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};
    private String nums1[] = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuffer numStr = new StringBuffer(20);
        if (num / 1000000000 != 0) {
            int bnum = num / 1000000000;
            numStr.append(getNumStr(bnum).toString());
            numStr.append(" Billion ");
            num %= 1000000000;
        }
        if (num / 1000000 != 0) {
            int mnum = num / 1000000;
            numStr.append(getNumStr(mnum).toString());
            numStr.append(" Million ");
            num %= 1000000;
        }
        if (num / 1000 != 0) {
            int tnum = num / 1000;
            numStr.append(getNumStr(tnum).toString());
            numStr.append(" Thousand ");
            num %= 1000;
        }
        if (num / 1 != 0) {
            numStr.append(getNumStr(num).toString());
            numStr.append(" ");
        }
        numStr.deleteCharAt(numStr.length() - 1);
        return numStr.toString();
    }
    
    public StringBuffer getNumStr(int num) {
        StringBuffer res = new StringBuffer(20);
        if (num == 0) {
            return res;
        }
        if (num / 100 != 0) {
            res.append(nums[num/100]);
            res.append(" Hundred ");
            num %= 100;
        }
        if (num / 10 != 0) {
            if (num / 10 > 1) {
                res.append(nums1[num/10]);
                res.append(" ");
                num %= 10;
            }
            else {
                res.append(nums[num]);
                res.append(" ");
                num = 0;
            }
        }
        if (num != 0) {
            res.append(nums[num]);
            res.append(" ");
        }
        return res.deleteCharAt(res.length() - 1);
    }
}
