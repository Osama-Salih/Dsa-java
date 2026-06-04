package dsa.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
    private int[][]vis;
    private Set<List<String>> set;
    private List<String> vec;
    private int[] delRow = new int[]{-1, 0, +1, 0};
    private int[] delCol = new int[]{0, +1, 0, -1};

    private void dfs(int row, int col, int[][]grid, int row0, int col0) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        vec.add(toString(row - row0, col - col0));

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                dfs(nrow, ncol, grid, row0, col0);
            }
        }
    }
    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    public int countDistinctIslands(int[][]grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new int[n][m];
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    vec = new ArrayList<>();
                    dfs(i, j, grid, i, j);
                    set.add(vec);
                }
            }
        }
        return set.size();
    }
}
// t = O(n * m)
// s = O(n * m)