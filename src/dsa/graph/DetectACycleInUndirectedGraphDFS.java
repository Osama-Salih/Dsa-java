package dsa.graph;

import java.util.ArrayList;

public class DetectACycleInUndirectedGraphDFS {
    private boolean []vis;
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfs(i, -1, adj)) {
                return true;
            }
        }
        return false;
    }
    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (dfs(it, node, adj)) return true;
            } else if (parent != it) {
                return true;
            }
        }
        return false;
    }
}
