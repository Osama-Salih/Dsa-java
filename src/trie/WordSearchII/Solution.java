package trie.WordSearchII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private TrieNode root = new TrieNode();
    private static class TrieNode {

    }
    private int ROWS, COLS;
    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        Set<String> res = new HashSet<>();

        for (String s : words) {
            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    if (dfs(board, r, c, 0, s)) {
                        res.add(s);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
    private boolean dfs(char[][]board, int r, int c, int i, String s) {
        if (i == s.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS
                || board[r][c] != s.charAt(i) || board[r][c] == '#') {
            return false;
        }

        board[r][c] = '#';
        boolean res = dfs(board, r - 1, c, i + 1, s) ||
                dfs(board, r + 1, c, i + 1, s) ||
                dfs(board, r, c + 1, i + 1, s) ||
                dfs(board, r, c - 1, i + 1, s);
        board[r][c] = s.charAt(i);
        return res;
    }

    public static void main(String[] args) {

    }
}