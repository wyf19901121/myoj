package leetcode;

public class AddandSearchWord {
	class letterNode {
		boolean isEnd;
		letterNode[] next;
		public letterNode() {
			// TODO Auto-generated constructor stub
			isEnd = false;
			next = new letterNode[26];
		}
	}
	letterNode head = new letterNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
    	letterNode temp = head;
    	for (int i = 0; i < word.length(); i++) {
    		int index = word.charAt(i) - 'a';
			if (temp.next[index] == null) {
				temp.next[index] = new letterNode();
			}
			temp = temp.next[index];
		}
    	temp.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	if (word.length() == 0) {
			return true;
		}
    	return searchK(word, 0, head);
    }
    public boolean searchK(String word, int index, letterNode curNode) {
		if (index == word.length() - 1) {
			if (word.charAt(index) == '.') {
				for (int i = 0; i < curNode.next.length; i++) {
					if (curNode.next[i] != null && curNode.next[i].isEnd) {
						return true;
					}
				}
				return false;
			}
			return curNode.next[word.charAt(index) - 'a'] != null && curNode.next[word.charAt(index) - 'a'].isEnd;
		}
		if (word.charAt(index) == '.') {
			for (int i = 0; i < curNode.next.length; i++) {
				if (curNode.next[i] != null && searchK(word, index + 1, curNode.next[i])) {
					return true;
				}
			}
			return false;
		}
		if (curNode.next[word.charAt(index) - 'a'] != null) {
			return searchK(word, index + 1, curNode.next[word.charAt(index) - 'a']);
		}
		return false;
	}
}
