package graph.findTheTownJudge;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] incoming = new int[n + 1];
        int[] outgoing = new int[n + 1];

        for (int[] t : trust) {
            incoming[t[1]]++;
            outgoing[t[0]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outgoing[i] == 0 && incoming[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
