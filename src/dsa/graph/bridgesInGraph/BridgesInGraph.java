package dsa.graph.bridgesInGraph;

import java.util.ArrayList;
import java.util.List;

// Bridges in Graph - Using Tarjan's Algorithm of time in and low time
public class BridgesInGraph {
    private int timer = 1;
    private boolean[] vis;

    private int[] tin;
    private int[] low;
    private List<List<Integer>> bridges;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
      List<List<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < n; i++) {
          adj.add(new ArrayList<>());
      }

      for (List<Integer> connection : connections) {
          int u = connection.get(0);
          int v = connection.get(1);
          adj.get(u).add(v);
          adj.get(v).add(u);
      }

        vis = new boolean[n];
        low = new int[n];
        tin = new int[n];
      dfs(0, -1, adj);
      return bridges;
    }
    private void dfs(int node, int parent, List<List<Integer>> adj) {
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;

        for (int it : adj.get(node)) {
            if (it == parent) continue;
            if (!vis[it]) {
                dfs(it, node, adj);
                low[node] = Math.min(low[it], low[node]);

                if (low[it] > tin[node]) {
                    bridges.add(List.of(it, node));
                }
            } else {
                low[node] = Math.min(low[it], low[node]);
            }
        }
    }
}
