package leetcode;

import java.util.ArrayList;

public class TextJustification {
    public ArrayList<String> reStrings = new ArrayList<>();
    public ArrayList<String> fullJustify(String[] words, int L) {
        int sum = 0, length = 0;
        for (int i = 0; i < words.length; i++) {
            if (length + words[i].length() + sum > L) {
                addString(words, i, sum, L);
                sum = 1;
                length = words[i].length();
            }
            else {
                sum++;
                length += words[i].length();
            }
        }
        addLast(words, words.length, sum, L);
        return reStrings;
    }
    public void addString(String[] words, int index, int sum, int L) {
        int length = 0;
        for (int i = index - sum; i < index; i++) {
            length += words[i].length();
        }
        int blanksum = (sum == 1 ? 1 : sum - 1);
        int perlen = (L - length) / blanksum;
        int[] blankArray = new int[blanksum];
        for (int i = 0; i < blankArray.length; i++) {
            if ((L - length) % blanksum > i) {
                blankArray[i] = perlen + 1;
            }
            else {
                blankArray[i] = perlen;
            }
        }
        String reString = "";
        int j = 0;
        for (int i = index - sum; i < index; i++) {
            reString += words[i];
            if (j < blankArray.length) {
                for (int k = 0; k < blankArray[j]; k++) {
                    reString += " ";
                }
            }
            j++;
        }
        reStrings.add(reString);
    }
    public void addLast(String[] words, int index, int sum, int L) {
        String res = "";
        for (int i = index - sum; i < index; i++) {
            if (i == index - 1) {
                res += words[i];
            }
            else {
                res += (words[i] + " ");
            }
        }
        for (int i = res.length(); i < L; i++) {
            res += " ";
        }
        reStrings.add(res);
    }
}
