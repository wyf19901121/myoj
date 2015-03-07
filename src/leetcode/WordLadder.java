package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
    	if (start.equals(end)) {
			return 1;
		}
    	Queue<String> ladder = new LinkedList<String>();
    	ladder.offer(start);
    	if (dict.isEmpty() || ladder.isEmpty()) {
			return 0;
		}
    	return getLength(ladder, dict, 2, end);
    }
    public int getLength(Queue<String> ladder2, Set<String> dict, int len, String end) {
		Queue<String> ladder = new LinkedList<String>();
    	do {
    		String start = ladder2.poll();
        	for (char i = 'a'; i <= 'z'; i++) {
    			for (int j = 0; j < start.length(); j++) {
    				if (start.charAt(j) != i) {
    					String temp = start.substring(0, j) + String.valueOf(i) + start.substring(j+1);
    					if (temp.equals(end)) {
    						return len;
    					}
    					if (dict.contains(temp)) {
    						ladder.offer(temp);
    						dict.remove(temp);
    					}
    				}
    			}
    		}
    	} while(!ladder2.isEmpty());
    	if (dict.isEmpty() || ladder.isEmpty()) {
			return 0;
		}
		return getLength(ladder, dict, len+1, end);
	}
}
