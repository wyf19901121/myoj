package leetcode;

import java.util.LinkedList;

public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
			return 0;
		}
        LinkedList<Integer> numList = new LinkedList<Integer>();
        for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int cur = ch - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					cur = 10 * cur + s.charAt(++i) - '0';
				}
//				System.out.println(cur + " " + i + " " + s.length());
				if (!numList.isEmpty() && (numList.getLast() == 2 || numList.getLast() == 3)) {
					int op = numList.removeLast();
					int last = numList.removeLast();
					numList.addLast(op == 2 ? last * cur : last / cur);
				}
				else {
					numList.addLast(cur);
				}
			}
			else {
				switch (ch) {
				case '+':
					numList.addLast(0);
					break;
				case '-':
					numList.addLast(1);
					break;
				case '*':
					numList.addLast(2);
					break;
				case '/':
					numList.addLast(3);
					break;
				default:
					break;
				}
			}
		}
        int res = numList.removeFirst();
//        System.out.println(res);
        while (!numList.isEmpty()) {
			int op = numList.removeFirst();
//			System.out.println(op);
			int next = numList.removeFirst();
//			System.out.println(next);
			res = op == 0 ? res + next : res - next;
		}
        return res;
    }
    public static void main(String[] args) {
		System.out.println(new BasicCalculatorII().calculate("0-2147483647"));
	}
}
