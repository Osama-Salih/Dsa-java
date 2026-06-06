package dsa.graph;

import java.util.ArrayList;

public class BipartiteGraphDFS {
    private int[]color;
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int V) {
        color = new int[V];
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, adj)) return false;
            }
        }
        return true;
    }
    private boolean dfs(int node, int col, ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;
        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (!dfs(it, 1 - col, adj)) return false;
            } else if (color[it] == col) return false;
        }
        return true;
    }
}
// t = O(V + (V + E))
// s = O(V)
