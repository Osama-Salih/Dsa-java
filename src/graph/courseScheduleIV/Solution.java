package graph.courseScheduleIV;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        int n = numCourses;

        if (prerequisites.length == 0) {
            for (int i = 0; i < queries.length; i++) {
                ans.add(false);
            }
            return ans;
        }

        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }


        boolean[][] prereq = new boolean[n][n];
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int it : adj.get(node)) {
                indegree[it]--;
                prereq[node][it] = true;
                for (int i = 0; i < n; i++) {
                    if (prereq[i][node]) {
                        prereq[i][it] = true;
                    }
                }
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        for (int[] qu : queries) {
            int u = qu[0];
            int v = qu[1];
            ans.add(prereq[u][v]);
        }
        return ans;
    }
}
// t = O(N^3 + Q)
// s = O(n^2)