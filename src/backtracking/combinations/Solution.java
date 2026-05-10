package backtracking.combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(1, new ArrayList<>(), n, k);
        return res;
    }
    private void dfs(int i, List<Integer> cur, int n, int k) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j <= n; j++) {
            cur.add(j);
            dfs(j + 1, cur, n, k);
            cur.remove(cur.size() - 1);
        }
    }
}

 // t = O(C(n, k) * k)
// s = O(k)