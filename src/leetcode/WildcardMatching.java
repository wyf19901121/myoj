package leetcode;

public class WildcardMatching {
//    public boolean isMatch(String s, String p) {
//        boolean[][] match = new boolean [s.length()+1][p.length()+1];
//        match[0][0] = true;
//        for (int i = 1; i < match[0].length; i++) {
//            match[0][i] = match[0][i-1] && p.charAt(i-1) == '*';
//        }
//        for (int j = 1; j < match[0].length; j++) {
//            for (int i = 1; i < match.length; i++) {
//                switch (p.charAt(j-1)) {
//                case '*':
//                    match[i][j] = match[i-1][j];
//                    break;
//                case '?':
//                    match[i][j] = match[i-1][j-1];
//                    break;
//                default:
//                    match[i][j] = match[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1);
//                    break;
//                }
//            }
//        }
//        return match[s.length()][p.length()];
//    }
//    public boolean isMatch(String s, String p) {
//        if (s.length() == 0 && p.length() == 0) {
//            return true;
//        }
//        if (p.length() == 0) {
//            return false;
//        }
//        if (p.charAt(0) == '*') {
//            while (p.length() > 0 && p.charAt(0) == '*') {
//                p = p.length() == 1 ? "" : p.substring(1);
//            }
//            while (s.length() != 0) {
//                if (isMatch(s, p)) {
//                    return true;
//                }
//                s = s.length() == 1 ? "" : s.substring(1);
//            }
//        }
//        else {
//            if (s.length() != 0 && (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0))) {
//                p = p.length() == 1 ? "" : p.substring(1);
//                s = s.length() == 1 ? "" : s.substring(1);
//                return isMatch(s, p);
//            }
//        }
//        return false;
//    }
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        int curS = 0, curP = 0, lastP = -1, lastS = -1;
        while (curS != s.length()) {
            if (curP < p.length()) {
                if (s.charAt(curS) == p.charAt(curP) || p.charAt(curP) == '?') {
                    curS++;
                    curP++;
                    continue;
                }
                if (p.charAt(curP) == '*') {
                    lastP = curP;
                    lastS = curS;
                    curP++;
                    continue;
                }
            }
            if (lastP != -1) {
                curP = lastP + 1;
                curS = lastS + 1;
                lastS++;
                continue;
            }
            return false;
        }
        while (curP < p.length() && p.charAt(curP) == '*') {
            curP++;
        }
        return curP == p.length();
    }
}
