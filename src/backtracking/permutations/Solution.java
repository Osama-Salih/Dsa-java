package backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    private void backtrack(int[] nums, List<Integer> cur, boolean[] used) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            cur.add(nums[i]);
            used[i] = true;

            backtrack(nums, cur, used);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}
