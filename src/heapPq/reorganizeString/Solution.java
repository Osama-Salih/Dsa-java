package heapPq.reorganizeString;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[1], a[1]));

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > (n + 1) / 2) {
                return "";
            }
            maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        StringBuilder sb = new StringBuilder();
        int[]prev = null;
        while(!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            sb.append((char) curr[0]);
            curr[1]--;

            if (prev != null && prev[1] > 0) {
                maxHeap.offer(prev);
            }
            prev = curr;
        }

        return sb.length() == n ? sb.toString() : "";
    }
}

// t = O(n log k)
// s = O(k)