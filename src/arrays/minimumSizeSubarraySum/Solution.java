package arrays.minimumSizeSubarraySum;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minWindowLen = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentWindowSum += nums[windowEnd];

            while (currentWindowSum >= target) {
                minWindowLen = Math.min(minWindowLen, windowEnd - windowStart + 1);
                currentWindowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return minWindowLen == Integer.MAX_VALUE ? 0 : minWindowLen;
    }
}
