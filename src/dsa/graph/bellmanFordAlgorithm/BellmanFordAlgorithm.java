package dsa.graph.bellmanFordAlgorithm;

import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    public int[] bellmanFord(int V, List<List<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[S] = 0;

        // O(V * E)
        for (int i = 0; i < V - 1; i++) {
            for (List<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Nth relaxation to check negative cycle
        for (List<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }
        return dist;
    }
}
