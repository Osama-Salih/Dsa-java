package arrays.rotateArray;

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length - 1;
        k %= n;

        reverse(nums, 0, n);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n);
    }
    private void reverse(int []nums, int l, int r) {
        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}