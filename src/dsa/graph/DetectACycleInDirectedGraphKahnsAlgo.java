package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectACycleInDirectedGraphKahnsAlgo {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }


        int i = 0, cnt = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            cnt++;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        return cnt != V;
    }
}
