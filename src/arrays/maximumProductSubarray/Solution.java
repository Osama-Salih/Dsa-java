package arrays.maximumProductSubarray;

class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int reslut = max;

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];

            int temp = Math.max(cur, Math.max(cur * max, cur * min));
            min = Math.min(cur, Math.min(cur * min, cur * max));
            max = temp;
            reslut = Math.max(reslut, max);
        }
        return reslut;
    }
}