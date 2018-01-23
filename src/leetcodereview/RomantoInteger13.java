/**
 * Created by wangyifan on 2018/1/23.
 */
public class RomantoInteger13 {
    public int romanToInt(String s) {
        char[] str = s.toCharArray();
        int num = 0;
        int i = 0;
        while (i < str.length) {
            switch (str[i]) {
                case 'M': //1000
                    num += 1000;
                    i++;
                    break;
                case 'D': //500
                    num += 500;
                    i++;
                    break;
                case 'C': //100
                    if (i < str.length - 1 && str[i + 1] == 'M') {
                        num += 900;
                        i += 2;
                    } else if (i < str.length - 1 && str[i + 1] == 'D') {
                        num += 400;
                        i += 2;
                    } else {
                        num += 100;
                        i++;
                    }
                    break;
                case 'L': //50
                    num += 50;
                    i++;
                    break;
                case 'X': //10
                    if (i < str.length - 1 && str[i + 1] == 'C') {
                        num += 90;
                        i += 2;
                    } else if (i < str.length - 1 && str[i + 1] == 'L') {
                        num += 40;
                        i += 2;
                    } else {
                        num += 10;
                        i++;
                    }
                    break;
                case 'V': //5
                    num += 5;
                    i++;
                    break;
                case 'I': //1
                    if (i < str.length - 1 && str[i + 1] == 'X') {
                        num += 9;
                        i += 2;
                    } else if (i < str.length - 1 && str[i + 1] == 'V') {
                        num += 4;
                        i += 2;
                    } else {
                        num += 1;
                        i++;
                    }
            }
        }
        return num;
    }
}
