package leetcode;

public class ValidNumber {
    public boolean isNumber(String s) {
    	String regex = "[+-]?\\d+(\\.d+)?(\\d+e[+-]d+)?";
    	if (s.trim().matches(regex)) {
			return true;
		}
    	return false;
    }
}
