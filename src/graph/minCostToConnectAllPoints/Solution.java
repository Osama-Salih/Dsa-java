package graph.minCostToConnectAllPoints;

import dsa.graph.disjointSet.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    private static class Tuple {
        int src;
        int dist;
        int cost;
        public Tuple(int src, int dist, int cost) {
            this.src = src;
            this.dist = dist;
            this.cost = cost;
        }
    }
    private static class Pair {
        int wt;
        int node;
        public Pair(int wt, int node) {
            this.wt = wt;
            this.node = node;
        }
    }
//    public int minCostConnectPoints(int[][] points) {
//        List<Tuple> edges = new ArrayList<>();
//        int n = points.length;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int[] point1 = points[i];
//                int[] point2 = points[j];
//                int wt = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
//                edges.add(new Tuple(i, j, wt));
//            }
//        }
//
//        Collections.sort(edges, (a, b) -> a.cost - b.cost);
//        DisjointSet ds = new DisjointSet(n);
//        int mstSum = 0, edgeUsed = 0;
//
//        for (Tuple edge : edges) {
//            if (ds.findUPer(edge.src) != ds.findUPer(edge.dist)) {
//                mstSum += edge.cost;
//                edgeUsed++;
//                ds.unionBySize(edge.src, edge.dist);
//                if (edgeUsed == n - 1) break;
//            }
//        }
//        return mstSum;
//    }
    // t = O(n^2 log(n))
    // s = O(n^2)
    // Kruskal's algorithm

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new Pair(0, 0));

        int mstCost = 0, edgesUsed = 0;
        while(edgesUsed < n) {
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.wt;

            if (vis[node]) continue;

            vis[node] = true;
            mstCost += wt;
            edgesUsed++;

            for (int next = 0; next < n; next++) {
                if (!vis[next]) {
                    int dist = Math.abs(points[node][0] - points[next][0]) +
                               Math.abs(points[node][1] - points[next][1]);

                    pq.offer(new Pair(dist,next));
                }
            }
        }
        return mstCost;
    }
    // t = O(n^2 log(n))
    // s = O(n^2)
    // Prim's algorithm
}
