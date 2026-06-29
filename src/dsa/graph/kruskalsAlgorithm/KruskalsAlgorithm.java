package dsa.graph.kruskalsAlgorithm;
import dsa.graph.disjointSet.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge {
    int src, dist, weight;
    public Edge(int src, int dist, int weight) {
        this.src = src;
        this.dist = dist;
        this.weight = weight;
    }
}
public class KruskalsAlgorithm {

    public int spanningTree(int V, List<List<List<Integer>>> adj) {
      List<Edge> edges = new ArrayList<>();
      for (int u = 0; u < V; u++) {
          for (List<Integer> it : adj.get(u)) {
              int v = it.get(0);
              int wt = it.get(1);

              if (u < v) {
                  edges.add(new Edge(u, v, wt));
              }
          }
      }

      Collections.sort(edges, (a, b) -> a.weight - b.weight);
      DisjointSet ds = new DisjointSet(V);
      int mstSum = 0;

      for (Edge edge : edges) {
          if (ds.findUPer(edge.src) != ds.findUPer(edge.dist)) {
              mstSum += edge.weight;
              ds.unionBySize(edge.src, edge.dist);
          }
      }
      return mstSum;
    }
}
// t = O(E log E)
// s = O(n)
