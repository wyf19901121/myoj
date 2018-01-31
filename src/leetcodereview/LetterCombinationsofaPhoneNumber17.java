import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyifan on 2018/1/31.
 */
public class LetterCombinationsofaPhoneNumber17 {
    private  List<String> result = new ArrayList<>();
    private void letterCombinations(String digits, int index, StringBuffer tempStr) {
        if (index == digits.length()) {
            result.add(tempStr.toString());
            return;
        }
        int num = 3;
        char start = 'a';
        if (digits.charAt(index) == '7' || digits.charAt(index) == '9') {
            num = 4;
        }
        switch (digits.charAt(index)) {
            case '2':
                start = 'a';
                break;
            case '3':
                start = 'd';
                break;
            case '4':
                start = 'g';
                break;
            case '5':
                start = 'j';
                break;
            case '6':
                start = 'm';
                break;
            case '7':
                start = 'p';
                break;
            case '8':
                start = 't';
                break;
            case '9':
                start = 'w';
                break;
            default:
                return;
        }
        for (int i = 0; i < num; i++) {
            tempStr.append((char) (start + i));
            letterCombinations(digits, index + 1, tempStr);
            tempStr.deleteCharAt(index);
        }
    }
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuffer tempStr = new StringBuffer();
        letterCombinations(digits, 0, tempStr);
        return result;
    }
}
