package arrays.maximumSubarray;

class Solution {
    public int maxSubArray(int[] nums)
    {
        int max=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;++i)
        {
            nums[i]=Math.max(nums[i],nums[i]+nums[i-1]);
            max=Math.max(max,nums[i]);
        }
        return Math.max(max,nums[0]);
    }
}