package graph.networkDelayTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        Arrays.fill(dist, (int) 1e9);
        dist[k] = 0;

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            adj.get(u).add(new int[]{v, wt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int dis = curr[0];
            int node = curr[1];

            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int edgeWeight = it[1];

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.offer(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        int minTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9) {
                return -1;
            }
            minTime = Math.max(minTime, dist[i]);
        }
        return minTime;
    }
}
// t = O(E log(V))
// s = O(V + E)