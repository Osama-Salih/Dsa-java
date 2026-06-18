package graph.graphValidTree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private boolean[] vis;

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        if (!dfs(0, -1, adj)){
            return false;
        }

        for (boolean node : vis) {
            if (!node) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int node,int parent, List<List<Integer>> adj) {
        vis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (!dfs(it,node,adj)) return false;
            } else if (it != parent) return false;
        }
        return true;
    }
}
// t = O(V + E)
// s = O(V)