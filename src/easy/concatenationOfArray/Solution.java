package easy.concatenationOfArray;

public class Solution {
    public int[] getConcatenation(int[] nums) {
        int []arr = new int[nums.length + nums.length];
        int a=0;

        for (int i = 0; i < nums.length; i++) {
            arr[a++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            arr[a++] = nums[i];
        }
        return arr;
    }
}
