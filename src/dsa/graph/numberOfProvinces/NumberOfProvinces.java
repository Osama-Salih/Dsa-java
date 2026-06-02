package dsa.graph.numberOfProvinces;

import java.util.ArrayList;

public class NumberOfProvinces {
    public int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                }
            }
        }

        boolean []vis = new boolean[V];
        int cnt = 0;
        for(int i = 0; i < V; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(i, adjList, vis);
            }
        }
        return cnt;
    }
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[]vis) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj, vis);
            }
        }
    }
}
