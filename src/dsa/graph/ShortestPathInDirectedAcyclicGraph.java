package dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//  Topological Sort
public class ShortestPathInDirectedAcyclicGraph {
    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    private static void topoSort(int node, List<List<Pair>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;

        for (Pair it : adj.get(node)) {
            int v = it.first;
            if (!vis[v]) {
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }
    public static int[] shortestPath(int N, int M, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }


        for (int i = 0; i < M; i++) {
            int v = edges[i][0];
            int u = edges[i][1];
            int wt = edges[i][2];
            adj.get(v).add(new Pair(u, wt));
        }

        boolean[] vis = new boolean[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                topoSort(i, adj, vis, st);
            }
        }


        int[] dist = new int[N];
        Arrays.fill(dist, (int)1e9);
        dist[0] = 0;
        while(!st.isEmpty()) {
            int node = st.pop();

            for (Pair it : adj.get(node)) {
                int v = it.first;
                int wt = it.second;
                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }
        return dist;
    }
}
