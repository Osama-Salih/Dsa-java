package dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrintShortestPath {
    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int[][]edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
            parent[i] = i;
        }

        dist[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.offer(new Pair(0, 1));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.second;
            int dis = curr.first;

            if (dis > dist[node]) continue;

            for (Pair it : adj.get(node)) {
                int edgeWeight = it.second;
                int adjNode = it.first;

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.offer(new Pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (dist[n] == (int) 1e9) {
            path.add(-1);
            return path;
        }

        int node = n;
        while(parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
