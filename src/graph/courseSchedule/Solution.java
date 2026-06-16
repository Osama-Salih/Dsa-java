package graph.courseSchedule;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private boolean[] vis;
    private boolean[] pathVis;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0])
                    .add(prerequisites[i][1]);
        }

        vis = new boolean[numCourses];
        pathVis = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (!dfs(i, adj))
                    return false;
            }
        }
        return true;
    }
    private boolean dfs(int node, List<List<Integer>> adj) {
        vis[node] = true;
        pathVis[node] = true;

        for (int it : adj.get(node)) {
            if(!vis[it]) {
                if (!dfs(it, adj)) return false;
            } else if (pathVis[it]) return false;
        }

        pathVis[node] = false;
        return true;
    }
}
// t =  O(V + E)
// s = O(V)