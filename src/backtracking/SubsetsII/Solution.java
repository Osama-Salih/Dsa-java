package backtracking.SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(0, new ArrayList<>(), nums);
        return res;
    }
    private void backtrack(int start, List<Integer> cur, int[] nums) {
        res.add(new ArrayList<>(cur));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            backtrack(i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
// t = O(n * 2n)
// s = O(n)