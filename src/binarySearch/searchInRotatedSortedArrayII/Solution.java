package binarySearch.searchInRotatedSortedArrayII;

public class Solution {
    public boolean search(int[] nums, int target) {
        return modifiedBinarySearch(nums, target, 0, nums.length - 1);
    }
    private boolean modifiedBinarySearch(int []nums, int target, int left, int right) {
        if (left > right)
            return false;

        int m = left + ((right - left) / 2);
        if (nums[m] == target)
            return true;

        if (nums[m] == nums[left] && nums[m] == nums[right]){
            return modifiedBinarySearch(nums, target, left + 1, right - 1);
        }

        if (nums[m] >= nums[left]){
            if (nums[left] <= target && target <= nums[m])
                return modifiedBinarySearch(nums, target, left, m - 1);
            else
                return modifiedBinarySearch(nums, target, m + 1, right);
        } else {
            if (nums[m] <= target && target <= nums[right])
                return modifiedBinarySearch(nums, target, m + 1, right);
            else
                return modifiedBinarySearch(nums, target, left, m - 1);
        }
    }
}
