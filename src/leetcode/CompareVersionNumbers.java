package leetcode;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
    	int dot1 = -1, dot2 = -1, begin1 = 0, begin2 = 0;
    	do {
    		int ver1 = 0, ver2 = 0;
    		if (begin1 < version1.length()) {
    			dot1 = version1.indexOf('.', begin1);
    			if (dot1 < 0) {
    				dot1 = version1.length();
    			} 
    			ver1 = Integer.parseInt(version1.substring(begin1, dot1));
    			begin1 = dot1 + 1;
    		}
    		if (begin2 < version2.length()) {
    			dot2 = version2.indexOf('.', begin2);
    			if (dot2 < 0) {
    				dot2 = version2.length();
    			}
    			ver2 = Integer.parseInt(version2.substring(begin2, dot2));
    			begin2 = dot2 + 1;
    		}
    		if (ver1 > ver2) {
    			return 1;
    		}
    		else if (ver1 < ver2) {
    			return -1;
    		}
    		
    	} while (dot1 < version1.length() || dot2 < version2.length());
    	return 0;
    }
}
