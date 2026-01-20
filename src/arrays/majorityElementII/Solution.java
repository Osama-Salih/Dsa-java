package arrays.majorityElementII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> majorityElement(int []nums) {
       Map<Integer, Integer> count = new HashMap<>();

       for (int num : nums) {
           count.put(num, count.getOrDefault(num, 0) + 1);

           if (count.size() > 2) {
               Map<Integer, Integer> newCount = new HashMap<>();
               for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                   if (entry.getValue() > 1) {
                       newCount.put(entry.getKey(), entry.getValue());
                   }
               }
               count = newCount;
           }
       }

       List<Integer> res = new ArrayList<>();
       for (int key : count.keySet()) {
           int frequancy = 0;
           for (int num : nums) {
               if (key == num) frequancy++;
           }
           if (frequancy > nums.length / 3) {
               res.add(key);
           }
       }
       return res;
    }
}
