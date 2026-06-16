package dsa.graph;

import java.util.*;

public class FindEventualSafeStatesBFSTopoSort {
    public List<Integer> eventualSafeNodes(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);

            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
// t = O(n log n)
// s = O(n)
