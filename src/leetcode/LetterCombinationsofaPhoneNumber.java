package leetcode;

import java.util.List;
import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {
	public List<String> combinations = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
			return combinations;
		}
        char[] combination = new char [digits.length()];
        buildCombination(digits, combination, digits.length());
        return combinations;
    }
    public void buildCombination(String phoneNum, char[] combination, int pos) {
		if (pos == 0) {
			combinations.add(new String(combination));
			return;
		}
		int index = pos - 1;
		char phoneDigit = phoneNum.charAt(index);
		switch (phoneDigit) {
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
			char firstLetter = (char) ((phoneDigit-'2')*3+'a');
			for (int i = 0; i < 3; i++) {
				combination[index] = (char) (firstLetter + i);
				buildCombination(phoneNum, combination, index);
			}
			break;
		case '7':
			for (char i = 'p'; i < 't'; i++) {
				combination[index] = i;
				buildCombination(phoneNum, combination, index);
			}
			break;
		case '8':
			for (char i = 't'; i < 'w'; i++) {
				combination[index] = i;
				buildCombination(phoneNum, combination, index);
			}
			break;
		case '9':
			for (char i = 'w'; i <= 'z'; i++) {
				combination[index] = i;
				buildCombination(phoneNum, combination, index);
			}
			break;
		default:
			buildCombination(phoneNum, combination, index);
			break;
		}
	}
}
