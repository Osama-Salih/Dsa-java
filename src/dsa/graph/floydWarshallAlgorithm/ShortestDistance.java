package dsa.graph.floydWarshallAlgorithm;

public class ShortestDistance {
    public void shortestDistance(int[][]matrix) {
       int n = matrix.length;
       int INF = (int) 1e9;

       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               if (matrix[i][j] == -1) {
                   matrix[i][j] = INF;
               }
           }
       }

       for (int k = 0; k < n; k++) {
           for(int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                   matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
               }
           }
       }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == INF) {
                    matrix[i][j] = -1;
                }
            }
        }


        // to detect neg cycle
//        for (int i = 0; i < n; i++) {
//            if (matrix[i][i] < 0) {
//                return;
//            }
//        }
    }
}

// t = O(n^3)
// s = O(n^2) for modified the matrix input
