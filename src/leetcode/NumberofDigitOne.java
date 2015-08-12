package leetcode;

public class NumberofDigitOne {
    public int countDigitOne(int n) {
    	if (n < 0) {
			return 0;
		}
    	System.out.println(n);
    	long div = 1;
    	int len = 1;
    	while (div * 10 <= n) {
			div *= 10;
			len++;
		}
    	
    	int first = (int) (n / div);
    	
    	if (len == 1 && first != 0) {
			return 1;
		}
    	if (len == 1 && first == 0) {
			return 0;
		}
    	int numFirst = 0;
    	if (first > 1) {
			numFirst = (int) div;
		}
    	else {
			numFirst = (int) (n - div + 1);
		}
    	int numOther = (int) (first * (len - 1) * div / 10);
    	int numSecond = countDigitOne((int) (n % div));
    	return numFirst + numOther + numSecond;
    }
}
