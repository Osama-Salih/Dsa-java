package graph.surroundedRegions;

public class Solution {
    private int[][] directions = new int[][] {{1, 0}, {-1, 0},
                                              {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        boolean[][] vis = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if ((r == 0 || r == ROWS - 1 || c == 0 || c == COLS -1)
                        && board[r][c] == 'O') {
                    dfs(r, c, vis, board);
                }
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O' && !vis[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
    }
    private void dfs(int r, int c, boolean[][]vis, char[][]board) {
        vis[r][c] = true;

        for (int[] dir : directions) {
            int nrow = r + dir[0];
            int ncol = c + dir[1];

            if (nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length
                    && board[nrow][ncol] == 'O' && !vis[nrow][ncol]) {
                dfs(nrow, ncol, vis, board);
            }
        }
    }
}
// t = O(n * m)
// s = O(n * m)
