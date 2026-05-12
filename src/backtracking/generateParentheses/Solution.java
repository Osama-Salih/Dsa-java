package backtracking.generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(0, 0, sb, n, res);
        return res;
    }
    private void backtrack(int openN, int closeN, StringBuilder sb, int n, List<String> res) {
        if (openN == closeN && openN == n) {
            res.add(sb.toString());
            return;
        }

        if (openN < n) {
            sb.append('(');
            backtrack(openN + 1, closeN, sb, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeN < openN) {
            sb.append(')');
            backtrack(openN, closeN + 1, sb, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
