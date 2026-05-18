package backtracking.NQueensII;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private Set<Integer> col = new HashSet<>();
    private Set<Integer> posDiag = new HashSet<>();
    private Set<Integer> negDiag = new HashSet<>();
    private int numQueens = 0;

    public int totalNQueens(int n) {
        backtrack(0, n);
        return numQueens;
    }
    private void backtrack(int r, int n) {
        if (r == n) {
            numQueens++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) continue;

            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);

            backtrack(r + 1, n);

            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
        }
    }
}
// t = O(n!)
// s = O(n)