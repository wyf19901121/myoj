package codebeauty;

import java.math.BigInteger;

public class MaxCommonDivisor {
    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
    
    public BigInteger gcd(BigInteger x, BigInteger y) {
        if (x.compareTo(y) < 0) {
            return gcd(y, x);
        }
        return y.equals(0) ? x : gcd(y, x.subtract(y));
    }
    
    public int gcdUpdate(int x, int y) {
        if (y == 0) {
            return x;
        }
        if (x < y) {
            return gcdUpdate(y, x);
        }
        if ((x & 1) == 0 && (y & 1) == 0) {
            return gcdUpdate(x >> 1, y >> 1) << 1;
        }
        if ((x & 1) == 0) {
            return gcdUpdate(x >> 1, y);
        }
        if ((y & 1) == 0) {
            return gcdUpdate(x, y >> 1);
        }
        
        return gcdUpdate(y, x - y);
    }
}
