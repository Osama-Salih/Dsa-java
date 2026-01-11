package arrays.sortColors;

public class Solution {
    public void sortColors(int[] nums) {
        int low, mid, high;
        mid = low = 0;
        high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(mid, low, nums);
                low++;
            } else if(nums[mid] == 2) {
                swap(mid, high, nums);
                high--;
                mid--;
            }
            mid++;
        }
    }
    private void swap(int n1, int n2, int[]nums) {
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }
}
