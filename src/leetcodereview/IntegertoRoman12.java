/**
 * Created by wangyifan on 2018/1/18.
 */
public class IntegertoRoman12 {
    public String intToRoman(int num) {
        int nums[] = {1, 5, 10, 50, 100, 500, 1000};
        char romans[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        StringBuilder romanStringBuilder = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            switch (num/nums[i]) {
                case 1:
                    if (i == 0 || num/nums[i-1] != 9) {
                        romanStringBuilder.append(romans[i]);
                    }
                    else {
                        romanStringBuilder.append(romans[i-1]);
                        romanStringBuilder.append(romans[i+1]);
                        i--;
                    }
                    break;
                case 2:
                    romanStringBuilder.append(romans[i]);
                    romanStringBuilder.append(romans[i]);
                    break;
                case 3:
                    romanStringBuilder.append(romans[i]);
                    romanStringBuilder.append(romans[i]);
                    romanStringBuilder.append(romans[i]);
                    break;
                case 4:
                    romanStringBuilder.append(romans[i]);
                    romanStringBuilder.append(romans[i+1]);
                    break;
            }
            num = num - num/nums[i]*nums[i];
        }
        return romanStringBuilder.toString();
    }
}
