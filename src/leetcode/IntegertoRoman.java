package leetcode;

public class IntegertoRoman {
    private int Num[] = {1, 5, 10, 50, 100, 500, 1000};
    private char Roman[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    public String intToRoman(int num) {
    	StringBuilder reStringBuilder = new StringBuilder();
    	for (int i = Num.length - 1; i >= 0; i--) {
			switch (num/Num[i]) {
			case 1:
				if (i == 0 || num/Num[i-1] != 9) {
					reStringBuilder.append(Roman[i]);
				}
				else {
					reStringBuilder.append(Roman[i-1]);
					reStringBuilder.append(Roman[i+1]);
					i--;
				}
				break;
			case 2:
				reStringBuilder.append(Roman[i]);
				reStringBuilder.append(Roman[i]);
				break;
			case 3:
				reStringBuilder.append(Roman[i]);
				reStringBuilder.append(Roman[i]);
				reStringBuilder.append(Roman[i]);
				break;
			case 4:
				reStringBuilder.append(Roman[i]);
				reStringBuilder.append(Roman[i+1]);
			default:
				break;
			}
			num = num - num/Num[i]*Num[i];
		}
    	return reStringBuilder.toString();
    }
}
