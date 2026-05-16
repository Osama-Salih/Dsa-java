package backtracking.partitionToKEqualSumSubsets;

import java.util.Arrays;

public class Solution {

    private boolean[] used;
    private int target;
    private int n;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;

        this.target = sum / k;
        this.n = nums.length;
        this.used = new boolean[n];

        Arrays.sort(nums);
        reverse(nums);

        return backtrack(nums, k, 0, 0);
    }
    private boolean backtrack(int[] nums, int k, int start, int curSum) {
        if (k == 0) return true;
        if (curSum == target) return backtrack(nums, k - 1, 0, 0);

        for (int i = start; i < n; i++) {
            if (used[i] || curSum + nums[i] > target) continue;
            used[i] = true;
            if (backtrack(nums, k, i + 1,curSum + nums[i])) return true;
            used[i] = false;
            if (curSum == 0) return false;
        }
        return false;
    }
    private void reverse(int[] nums) {
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
// t = O(k * 2n)
// s = O(n)