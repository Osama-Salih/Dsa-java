package arrays.twoSum;

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static int[] two_sum(int []nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
