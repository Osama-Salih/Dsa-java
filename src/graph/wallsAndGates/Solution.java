package graph.wallsAndGates;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private final int[][] directions = {{1, 0}, {-1, 0},
            {0, 1}, {0, -1}};
    private static class Pair {
        int first;
        int second;
        int third;

        public Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new Pair(r, c, 0));
                }
            }
        }

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int distance = q.peek().third;
            q.remove();

            grid[row][col] = distance;
            for (int[] dir : directions) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && grid[nrow][ncol] == 2147483647 && !vis[nrow][ncol]){
                    q.offer(new Pair(nrow, ncol, distance + 1));
                    vis[nrow][ncol] = true;
                }
            }
        }
    }
}

