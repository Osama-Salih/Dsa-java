package graph.redundantConnection;

public class Solution {
    private static class DSU {
        private int[] parent;
        private int[] size;

        public DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findUParent(int node) {
            if (node == parent[node]) {
                return node;
            }

            int ulp = findUParent(parent[node]);
            parent[node] = ulp;
            return parent[node];
        }

        public void unionBySize(int u, int v) {
            int parentU = findUParent(u);
            int parentV = findUParent(v);

            if (parentU == parentV) return;

            if (size[parentU] > size[parentV]) {
                parent[parentV] = parentU;
                size[parentU] = size[parentU] + size[parentV];
            } else {
                parent[parentU] = parentV;
                size[parentV] = size[parentV] + size[parentU];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] ans = new int[2];
        DSU ds = new DSU(n);

        for (int[] edge : edges) {
            if (ds.findUParent(edge[0]) == ds.findUParent(edge[1])) {
                ans[0] = edge[0];
                ans[1] = edge[1];
            }
            ds.unionBySize(edge[0], edge[1]);
        }
        return ans;
    }
}
