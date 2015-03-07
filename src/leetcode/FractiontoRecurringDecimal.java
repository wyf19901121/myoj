package leetcode;

import java.util.HashMap;

public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
			return "";
		}
        if (numerator == 0) {
        	return "0";
        }
        long Son = numerator;
        long Mom = denominator;
        long son = (long) Math.abs(Son);
        long mom = (long) Math.abs(Mom);
        String resString = "";
        if (Son * Mom < 0) { //负数
			resString = "-" + resString;
		}
        if (son/mom == 0) { //小于1的小数
        	resString += "0";
        }
        else {
            resString += String.valueOf(son/mom);
        }
        son = son%mom;
        if (son == 0) {
        	return resString;
        }
        resString += ".";
        HashMap<Long, Integer> remainderMap = new HashMap<Long, Integer>();
        remainderMap.put(son, resString.length());
        while (son != 0) {
        	son *= 10;
        	resString += String.valueOf(son/mom);
        	son %= mom;
        	if (remainderMap.containsKey(son)) {
				int i = remainderMap.get(son);
				resString = resString.substring(0, i) + "(" + resString.substring(i) + ")";
				return resString;
			}
        	remainderMap.put(son, resString.length());
		}
        return resString;
    }
}
