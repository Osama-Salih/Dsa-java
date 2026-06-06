package dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    private int[] vis;
    private int[] pathVis;

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
    public List<Integer> eventualSafeNodes(ArrayList<ArrayList<Integer>> adj, int V) {
        vis = new int[V];
        pathVis = new int[V];
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj);
            }
        }

        for (int node : pathVis) {
            if (node == 0) {
                safeNodes.add(node);
            }
        }
        return safeNodes;
    }
}