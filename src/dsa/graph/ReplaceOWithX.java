package dsa.graph;

public class ReplaceOWithX {
    private void dfs(int row, int col, int[][]vis, char[][]mat, int[]delRow, int[]delCol) {
        int n = mat.length;
        int m = mat[0].length;
        vis[row][col] = 1;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, mat, delRow, delCol);
            }
        }
    }
    public char[][] fill(int n, int m, char[][]mat) {
        int[][] vis = new int[n][m];
        int[] delRow = new int[]{-1, 0, +1, 0};
        int[] delCol = new int[]{0, +1, 0, -1};

        for (int i = 0; i < m; i++) {
            if (vis[0][i] == 0 && mat[0][i] == 'O') {
                dfs(0, i, vis, mat, delRow, delCol);
            }
            if (vis[n-1][i] == 0 && mat[n-1][i] == 'O') {
                dfs(n-1, i, vis, mat, delRow, delCol);
            }
        }
        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delRow, delCol);
            }

            if(vis[i][m-1] == 0 && mat[i][m-1] == 'O') {
                dfs(i, m-1, vis, mat, delRow, delCol);
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (vis[r][c] == 0 && mat[r][c] == 'O') {
                    mat[r][c] = 'X';
                }
            }
        }
        return mat;
    }
}
// t = O(n*m)
// s = O(n*m)
