package dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {
    private int[]color;
    private Queue<Integer> q;

    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int V) {
        color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1 && !check(i, adj)) {
                return false;
            }
        }
        return true;
    }
    private boolean check(int start, ArrayList<ArrayList<Integer>> adj) {
        q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;

        while(!q.isEmpty()) {
            int node = q.poll();

            for (int it : adj.get(node)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                } else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
