package codebeauty;

public class NumOfOne24 {
    public int numsOfOne(int n) {
        int div = 1;
        int num = 0;
        while (n / div != 0) {
            int highNum = n / (div * 10);
            int lowNum = n % div;
            int cur = n % (div * 10) / div;
            switch (cur) {
            case 0:
                num += highNum * div;
                break;
            case 1:
                num += highNum * div + lowNum + 1;
                break;
            default:
                num += (highNum + 1) * div;
                break;
            }
            div *= 10;
        }
        return num;
    }
    public int numsOfDigital(int n) {
        int div = 1;
        int num = 0;
        while (n / div != 0) {
            int highNum = n / (div * 2);
            int lowNum = n % div;
            int cur = n % (div * 2) / div;
            switch (cur) {
            case 0:
                num += highNum * div;
                break;
            case 1:
                num += highNum * div + lowNum + 1;
                break;
            default:
                num += (highNum + 1) * div;
                break;
            }
            div *= 2;
        }
        return num;
    }
    public static void main(String[] args) {
        System.out.println(new NumOfOne24().numsOfOne(99));
        System.out.println(new NumOfOne24().numsOfDigital(3));
    }
}
