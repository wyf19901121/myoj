package leetcodereview;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        StringBuffer newStr = new StringBuffer(2 * s.length() + 1);
        for (int i = 0; i < 2 * s.length() + 1; i++) {
            newStr.append((i & 1) == 0 ? '#' : s.charAt(i/2));
        }
        int maxIndex = 0;
        String tStr = "@" + newStr.toString() + "$";
        int[] lens = new int [tStr.length()];
        lens[0] = 1;
        int P = 0, P0 = 0;
        for (int i = 1; i < lens.length - 1; i++) {
            if (i < P && i + lens[2 * P0 - i] - 1 < P) {
                    lens[i] = lens[2 * P0 - i];
            }
            else {
                P = Math.max(i, P);
                for (int j2 = P + 1; j2 < lens.length; j2++) {
                    int j3 = 2 * i - j2;
                    if (tStr.charAt(j2) != tStr.charAt(j3)) {
                        break;
                    }
                    P++;
                }
                P0 = i;
                lens[i] = P - i + 1;
                maxIndex = lens[i] > lens[maxIndex] ? i : maxIndex;
            }
        }
        StringBuffer res = new StringBuffer(10);
        for (int i = maxIndex - lens[maxIndex] + 1; i < maxIndex + lens[maxIndex]; i++) {
            if (tStr.charAt(i) != '#') {
                res.append(tStr.charAt(i));
            }
        }
        return res.toString();
    }
}
