package leetcode;

public class IntegertoRoman {
    private int Num[] = {1, 5, 10, 50, 100, 500, 1000};
    private char Roman[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    public String intToRoman(int num) {
        String reString = "";
        for (int i = Num.length - 1; i >= 0; i--) {
            switch (num/Num[i]) {
            case 1:
                if (i == 0 || num/Num[i-1] != 9) {
                    reString += String.valueOf(Roman[i]);
                }
                else {
                    reString += (String.valueOf(Roman[i-1]) + String.valueOf(Roman[i+1]));
                    i--;
                }
                break;
            case 2:
                reString += (String.valueOf(Roman[i]) + String.valueOf(Roman[i]));
                break;
            case 3:
                reString += (String.valueOf(Roman[i]) + String.valueOf(Roman[i]) + String.valueOf(Roman[i]));
                break;
            case 4:
                reString += (String.valueOf(Roman[i]) + String.valueOf(Roman[i+1]));
                break;
            default:
                break;
            }
            num = num - num/Num[i]*Num[i];
        }
        return reString;
    }
}
