package leetcode;

public class ImplementTrie {
    class TrieNode {
        // Initialize your data structure here.
        boolean isEnd;
        char val;
        TrieNode[] sonNodes;
        public TrieNode() {
            isEnd = false;
            val = ' ';
            sonNodes = new TrieNode[26];
        }
    }
    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if (word.length() == 0 || search(word)) {
                return;
            }
            char[] letters = word.toCharArray();
            TrieNode tempNode = root;
            for (int i = 0; i < letters.length; i++) {
                int index = letters[i] - 'a';
                if (tempNode.sonNodes[index] == null) {
                    tempNode.sonNodes[index] = new TrieNode();
                    tempNode.sonNodes[index].val = letters[i];
                }
                if (i == letters.length - 1) {
                    tempNode.sonNodes[index].isEnd = true;
                }
                tempNode = tempNode.sonNodes[index];
            }
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if (word.length() == 0) {
                return true;
            }
            TrieNode temp = root;
            char[] letters = word.toCharArray();
            for (int i = 0; i < letters.length; i++) {
                int index = letters[i] - 'a';
                if (temp.sonNodes[index] == null) {
                    return false;
                }
                temp = temp.sonNodes[index];
            }
            return temp.isEnd;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if (prefix.length() == 0) {
                return true;
            }
            TrieNode temp = root;
            char[] letters = prefix.toCharArray();
            for (int i = 0; i < letters.length; i++) {
                int index = letters[i] - 'a';
                if (temp.sonNodes[index] == null) {
                    return false;
                }
                temp = temp.sonNodes[index];
            }
            return true;
        }
    }
}
