package graph.rottingOranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private final int[][] direction = {{1, 0},{-1, 0},{0, 1},{0, -1}};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int minute = 0;
        int cntFresh = 0;

        boolean[][]vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 2) {
                    vis[r][c] = true;
                    q.offer(new int[]{r, c, 0});
                }
                if (grid[r][c] == 1) cntFresh++;
            }
        }

        int cnt = 0;
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            minute = cell[2];

            for (int[] dir : direction) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && grid[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    q.offer(new int[]{nrow, ncol, minute + 1});
                    cnt++;
                }
            }
        }

        if (cnt != cntFresh) return -1;
        return minute;
    }
}
// t = O(n * m)
// s = O(n * m)