package graph.minimumHeightTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return List.of(0);

        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                leaves.offer(i);
            }
        }

        while(n > 2) {
            int size = leaves.size();
            for (int i = 0; i < size; i++) {
                int node = leaves.poll();
                n--;
                for (int it : adj.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 1) {
                        leaves.offer(it);
                    }
                }
            }
        }
        return new ArrayList<>(leaves);
    }
}
// t = O(V + E)
// s = O(V + E)