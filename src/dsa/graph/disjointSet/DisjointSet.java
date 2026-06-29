package dsa.graph.disjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    public List<Integer> rank = new ArrayList<>();
    public List<Integer> parent = new ArrayList<>();
    public List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPer(int node) {
        if (node == parent.get(node))
            return node;
        int ulp = findUPer(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPer(u);
        int ulp_v = findUPer(v);

        if (ulp_u == ulp_v) return;

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int upl_u = findUPer(u);
        int upl_v = findUPer(v);

        if (upl_v == upl_u) return;

        if (size.get(upl_u) < size.get(upl_v)) {
            parent.set(upl_u, upl_v);
            size.set(upl_v, size.get(upl_v) + size.get(upl_u));
        } else {
            parent.set(upl_v, upl_u);
            size.set(upl_u, size.get(upl_u) + size.get(upl_v));
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.findUPer(3) == ds.findUPer(7))
            System.out.println("Same");
        else
            System.out.println("Not same");

        ds.unionByRank(3, 7);

        if (ds.findUPer(3) == ds.findUPer(7))
            System.out.println("Same");
        else
            System.out.println("Not same");
    }
}
// t = O(a(n))
// s = O(n)
//  Disjoint Set | Union by Rank | Union by Size | Path Compression