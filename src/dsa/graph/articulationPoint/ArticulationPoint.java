package dsa.graph.articulationPoint;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {
    private boolean[] vis;
    private int[] tin;
    private int[] low;
    private int[] mark;
    private int timer = 1;

    private void dfs(int node, int parent, List<List<Integer>> adj) {
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;

        for (int it : adj.get(node)) {
            if (it == parent) continue;
            if (!vis[it]) {
                dfs(it, node, adj);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if (child > 1 && parent == -1) {
            mark[node] = 1;
        }
    }
    public List<Integer> articulationPoints(int n, List<List<Integer>> adj) {
        vis = new boolean[n];
        tin = new int[n];
        low = new int[n];
        mark = new int[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, adj);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i] == 1) {
                ans.add(i);
            }
        }

        if (ans.isEmpty()) {
            ans.add(-1);
        }
        return ans;
    }
}
