package heapPq.lastStoneWeight;

import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if (x != y) {
                maxHeap.offer(x - y);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
// t : O(n log n)
// s : O(n)