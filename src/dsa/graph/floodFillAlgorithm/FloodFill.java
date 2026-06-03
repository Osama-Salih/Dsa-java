package dsa.graph.floodFillAlgorithm;

public class FloodFill {
    public int[][] floodFill(int[][]image, int sr, int sc, int newColor) {
        int initCol = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        int[]delRow = new int[]{-1, 0, +1, 0};
        int[]delCol = new int[]{0, +1, 0, -1};
        int [][]ans = new int[n][m];
        copyArrays(image,ans, n, m);
        dfs(sr, sc, ans, image, delRow, delCol, initCol, newColor);
        return ans;
    }
    private void dfs(int row, int col, int[][]ans, int[][]image, int[]delRow, int[]delCol, int initCol, int newCol) {
        ans[row][col] = newCol;
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = delRow[i];
            int ncol = delCol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initCol && ans[nrow][ncol] != newCol) {
                dfs(nrow, ncol, ans, image, delRow, delCol, initCol, newCol);
            }
        }
    }
    private void copyArrays(int[][]image, int[][]ans, int n, int m) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                ans[r][c] = image[r][c];
            }
        }
    }
}
