import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
//        int arr[] = {5,4,-1,7,8};
          int arr[] = {1};

        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
      int curSum = 0;
      int maxSum = nums[0];

      for(int i = 0; i < nums.length; i++) {
          if (curSum < 0) {
              curSum = 0;
          }
          curSum += nums[i];
          maxSum = Math.max(curSum, maxSum);
      }
      return maxSum;
    }
}
