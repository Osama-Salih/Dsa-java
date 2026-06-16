package dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortAlgorithmDFS {
    private void dfs(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, st, adj);
            }
        }
        st.push(node);
    }
    public List<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, stack, adj);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }
}
