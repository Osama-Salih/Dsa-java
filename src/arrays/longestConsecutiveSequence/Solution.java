package arrays.longestConsecutiveSequence;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int longest = 0;

        for (int num : nums) {
            numSet.add(num);
        }
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while(numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}

