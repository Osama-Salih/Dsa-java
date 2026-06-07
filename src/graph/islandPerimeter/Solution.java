package graph.islandPerimeter;

public class Solution {

    private int[][]grid;
    private boolean[][]vis;
    private int rows;
    private int cols;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.vis = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    return dfs(r, c);
                }
            }
        }
        return 0;
    }
    private int dfs(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0){
            return 1;
        }
        if (vis[r][c]) {
            return 0;
        }

        vis[r][c] = true;
        return dfs(-1, 0) + dfs(+1, 0)
                + dfs(0, +1) + dfs(0, -1);
    }
}
