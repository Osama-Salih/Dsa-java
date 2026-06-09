package graph.pacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int[][] directions = {{1, 0}, {-1, 0},
            {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights);
            dfs(ROWS - 1, c, atl, heights);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, COLS - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }
        return res;
    }
    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;

        for (int[] dir : directions) {
            int nrow = r + dir[0];
            int ncol = c + dir[1];

            if (nrow >= 0 && nrow < heights.length && ncol >= 0
                    && ncol < heights[0].length && !ocean[nrow][ncol]
                    && heights[nrow][ncol] >= heights[r][c]) {
                dfs(nrow, ncol, ocean, heights);
            }
        }
    }
}
// t = O(n * m)
// s = O(n * m)