package heapPq.singleThreadedCPU;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        for (int i = 0; i < n; i++) {
            tasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] == b[0]
                        ? Integer.compare(a[1], b[1])
                        : Integer.compare(a[0], b[0]));
        Arrays.sort(tasks, Comparator.comparingInt(t -> t[0]));

        int i = 0, idx = 0;
        long time = tasks[0][0];
        int[] res = new int[n];

        while(!minHeap.isEmpty() || i < n) {
            while(i < n && time >= tasks[i][0]) {
                minHeap.offer(new int[]{tasks[i][1], tasks[i][2]});
                i++;
            }

            if (minHeap.isEmpty()) {
                time = tasks[i][0];
            } else {
                int[] task = minHeap.poll();
                time += task[0];
                res[idx++] = task[1];
            }
        }
        return res;
    }
}
