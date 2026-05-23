package trie;

public class PrefixTree {
    private TrieNode root;
    private static class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) return;

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            } else {
                current = current.children[index];
            }
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) return false;
            current = current.children[index];
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) return false;

        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) return false;
            current = current.children[index];
        }
        return true;
    }
}
// t = O(n) for each function call.
// s = O(t)