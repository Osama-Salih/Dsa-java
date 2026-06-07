package graph.numberOfIslands;

public class Solution {
    private boolean[][]vis;
    private int rows;
    private int cols;

    private int[] delRow;
    private int[] delCol;

    public int numIslands(char[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.vis = new boolean[rows][cols];

        delRow = new int[]{-1, 0, +1, 0};
        delCol = new int[]{0, +1, 0, -1};
        int num = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !vis[r][c]) {
                    dfs(r, c, grid);
                    num++;
                }
            }
        }
        return num;
    }
    private void dfs(int r, int c, char[][] grid) {
        vis[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nrow = r + delRow[i];
            int ncol = c + delCol[i];

            if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols
                && grid[nrow][ncol] == '1' && !vis[nrow][ncol]) {
                dfs(nrow, ncol, grid);
            }
        }
    }
}
// t = O(n * m)
// s = O(n * m)