package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> resArrayList = new ArrayList<>();
        if (s.length() <= 10) {
            return resArrayList;
        }
        boolean hashTable[] = new boolean [1024 * 1024];
        int convert[] = new int [26];
        convert[0] = 0; // 'A'
        convert[2] = 1; // 'C'
        convert[6] = 2; // 'G'
        convert[19] = 3; // 'T'
        int hashValue = 0;
        HashSet<Integer> strSet = new HashSet<Integer>();
        for (int i = 0; i < 9; i++) {
            hashValue <<= 2;
            hashValue |= convert[s.charAt(i) - 'A'];
        }
        for (int i = 9; i < s.length(); i++) {
            hashValue <<= 2;
            hashValue |= convert[s.charAt(i) - 'A'];
            hashValue &= ~(0x300000);
            if (hashTable[hashValue]) {
                if (!strSet.contains(hashValue)) {
                    strSet.add(hashValue);
                    resArrayList.add(s.substring(i - 9, i + 1));
                }
            }
            else {
                hashTable[hashValue] = true;
            }
        }
        return resArrayList;
    }
}
