package graph.NumberOfConnectedComponentsInAnUndirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private boolean[] vis;
    public int countComponents(int n, int[][] edges) {
        vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(i, adj);
            }
        }
        return cnt;
    }
    private void dfs(int node, List<List<Integer>> adj) {
        vis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj);
            }
        }
    }
}
// t = O(V + E)
// s = O(V + E)