package arrays.boatstoSavePeople;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, numBoats = 0;
        while(left <= right) {
            if (people[left] + people[right] <= limit) {
                numBoats++;
                left++;
                right--;
            } else {
                numBoats++;
                right--;
            }
        }
        return numBoats;
    }
}
