package leetcode;

public class Powxn {
    public double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = power(x, n/2);
        if (n % 2 == 0) {
            return res * res;
        }
        else {
            return res * res * x;
        }
    }
    public double pow(double x, int n) {
        if (n >= 0) {
            return power(x, n);
        }
        else {
            return 1.0/power(x, -n);
        }
    }
}
