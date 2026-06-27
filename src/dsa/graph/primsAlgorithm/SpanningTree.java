package dsa.graph.primsAlgorithm;

import java.util.List;
import java.util.PriorityQueue;

public class SpanningTree {
    private static class Pair {
        int distance;
        int node;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        boolean[] vis = new boolean[V];
        int sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Pair(0, 0));

        while(!pq.isEmpty()) {
            int node = pq.peek().node;
            int wt = pq.peek().distance;
            pq.remove();

            if (vis[node]) continue;

            vis[node] = true;
            sum += wt;

            for (List<Integer> it : adj.get(node)) {
                int adjNode = it.get(0);
                int edW = it.get(1);

                if (!vis[adjNode]) {
                    pq.offer(new Pair(adjNode, edW));
                }
            }
        }
        return sum;
    }
    // t = O(E log E)
    // s = O(E)
}
