package dsa.graph;

import java.util.ArrayList;

public class DetectCycleInADirectedGraphDFS {
    private int[] vis;
    private int[] pathVis;

    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
        vis = new int[V];
        pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        pathVis[node] = 1;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, adj)) return true;
            } else if (pathVis[it] == 1) return true;
        }

        pathVis[node] = 0;
        return false;
    }
}
