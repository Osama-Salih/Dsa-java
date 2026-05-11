package backtracking.permutationsII;

import java.util.*;

public class Solution {
    private List<List<Integer>> res;
    private Map<Integer, Integer> count;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        count = new HashMap<>();

        List<Integer> cur = new ArrayList<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        dfs(nums, cur);
        return res;
    }
    private void dfs(int[] nums, List<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int num : count.keySet()) {
            if (count.get(num) > 0) {
                cur.add(num);
                count.put(num, count.get(num) - 1);
                dfs(nums, cur);
                count.put(num, count.get(num) + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
// t = O(n! * n)
// s = O(n)


