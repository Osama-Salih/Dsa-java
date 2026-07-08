package dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponents {
    private void dfs(int node, boolean[] vis, List<List<Integer>> adj, Stack<Integer> stack) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, stack);
            }
        }
        stack.push(node);
    }
    private void dfs2(int node, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs2(it, vis, adj);
            }
        }
    }
    public int scc(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, stack);
            }
        }

        List<List<Integer>> reverseAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reverseAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            vis[i] = false;
            for (int it : adj.get(i)) {
                reverseAdj.get(it).add(i);
            }
        }

        int scc = 0;
        while(!stack.isEmpty()) {
            int node = stack.pop();
            if (!vis[node]) {
                scc++;
                dfs2(node, vis, reverseAdj);
            }
        }
        return scc;
    }
}
// O(V + E)
// O(V + E)