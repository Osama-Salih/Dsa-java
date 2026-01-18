package arrays.validSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        String inRow, inCol, inBox;
        char cell;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                cell = board[row][col];
                if (cell != '.') {
                    inCol = cell + " in col " + col;
                    inRow = cell + " in row " + row;
                    inBox = cell + " in box " + row / 3 + " - " + col / 3;

                    if (set.contains(inCol) || set.contains(inRow) || set.contains(inBox)) return false;
                    set.add(inCol);
                    set.add(inRow);
                    set.add(inBox);
                }
            }
        }
        return true;
    }
    // Time Complexity: O(1)
    // Space Complexity: O(1)
}
