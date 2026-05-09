package backtracking.combinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(0, new ArrayList<>(), 0, candidates, target);
        return res;
    }
    private void dfs(int i, List<Integer> cur, int total, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) return;
            if (j > i && nums[j] == nums[j -1]) continue;

            cur.add(nums[j]);
            dfs(j + 1, cur, total + nums[j], nums,target);
            cur.remove(cur.size() - 1);
        }
    }
}

// t = O(n * 2n)
// s = O(n)