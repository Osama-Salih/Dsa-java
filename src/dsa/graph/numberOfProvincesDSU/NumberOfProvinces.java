package dsa.graph.numberOfProvincesDSU;

import dsa.graph.disjointSet.DisjointSet;

import java.util.List;

public class NumberOfProvinces {
    public int numProvinces(List<List<Integer>> adj, int V) {
       DisjointSet ds = new DisjointSet(V);
       for (int i = 0; i < V; i++) {
           for (int j = 0; j < V; j++) {
               if (adj.get(i).get(j) == 1) {
                   ds.unionBySize(i, j);
               }
           }
       }
       int cnt = 0;
       for (int i = 0; i < V; i++) {
           if (ds.parent.get(i) == i) cnt++;
       }
       return cnt;
    }
}
// O(n ^ 2 * a(n))
// O(n)
