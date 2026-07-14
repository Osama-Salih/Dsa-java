package graph.cheapestFlightsWithinKStops;

import java.util.*;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int p = flight[2];
            adj.get(u).add(new int[]{v, p});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, src});

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int steps = curr[0];
            int cost = curr[1];
            int node = curr[2];

            if (steps > k) continue;
            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int edW = it[1];

                if (cost + edW < dist[adjNode]) {
                    dist[adjNode] = cost + edW;
                    q.offer(new int[]{steps + 1, cost + edW, adjNode});
                }
            }
        }
        return dist[dst] == (int) 1e9? -1 : dist[dst];
    }
}