package trie.WordSearchII;

import java.util.*;

public class Solution {
    private int ROWS, COLS;
    private Set<String> res;
    private boolean[][] visit;

    private static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }

        public void addWord(String word) {
            TrieNode cur = this;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new TrieNode());
                cur = cur.children.get(c);
            }
            cur.isWord = true;
        }
    }

    public List<String> findWords(char[][]board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        res = new HashSet<>();
        visit = new boolean[ROWS][COLS];

        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(board, r, c, root, "");
            }
        }
        return new ArrayList<>(res);
    }
    private void dfs(char[][]board, int r, int c, TrieNode node, String word) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS ||
                visit[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }

        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if (node.isWord) {
            res.add(word);
        }

        dfs(board, r - 1, c, node, word);
        dfs(board, r + 1, c, node, word);
        dfs(board, r, c + 1, node, word);
        dfs(board, r, c - 1, node, word);

        visit[r][c] = false;
    }
}
// t = O(W + m * n * 4L)
// s = O(W + m * n + L)