package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectACycleInUndirectedGraphBFS {
    private static class Pire {
        int parent;
        int node;

        public Pire(int p, int n) {
            parent = p;
            node = n;
        }
    }
    public boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean []vis = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!vis[i] && containsCycle(i, adj, vis)) {
                return true;
            }
        }
        return false;
    }
    private boolean containsCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[]vis) {
        Queue<Pire> q = new LinkedList<>();
        q.offer(new Pire(-1, node));
        vis[node] = true;

        while(!q.isEmpty()) {
            int parent = q.peek().parent;
            int source = q.peek().node;
            q.remove();

            for (int it : adj.get(source)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.offer(new Pire(source, it));
                } else {
                    if (parent != it) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
