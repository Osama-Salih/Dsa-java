package graph.pathWithMinimumEffort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    private static class Pair {
        int e;
        int r;
        int c;

        public Pair(int e, int r, int c) {
            this.e = e;
            this.r = r;
            this.c = c;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] efforts = new int[n][m];
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};

        for (int[] row : efforts) {
            Arrays.fill(row, (int) 1e9);
        }
        efforts[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.e - b.e);
        pq.offer(new Pair(0, 0, 0));

        while(!pq.isEmpty()) {
            int effort = pq.peek().e;
            int row = pq.peek().r;
            int col = pq.peek().c;
            pq.remove();

            if (effort > efforts[row][col]) continue;
            if (row == n - 1 && col == m - 1) return effort;

            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int edgeDiff = Math.abs(heights[row][col] - heights[nrow][ncol]);
                    if (Math.max(edgeDiff, effort) < efforts[nrow][ncol]) {
                        efforts[nrow][ncol] = Math.max(edgeDiff, effort);
                        pq.offer(new Pair(efforts[nrow][ncol], nrow, ncol));
                    }
                }
            }
        }
        return 0;
    }
}
// tc = O(n * m * log(n*m)
// sc = O(n * m)