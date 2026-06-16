package dsa.graph;

import java.util.*;

public class ShortestPathInUndirectedGraphWithUnitWeights {
    public  int[] shortestPath( int N, int M, int src, int[][]edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while(!q.isEmpty()) {
            int node = q.poll();

            for (int it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = 1 + dist[node];
                    q.offer(it);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
