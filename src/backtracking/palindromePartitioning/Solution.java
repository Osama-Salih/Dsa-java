package backtracking.palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();

        dfs(0, part, s, res);
        return res;
    }
    private void dfs(int i, List<String> part, String s, List<List<String>> res) {
        if (i == s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPali(s, i, j)) {
                part.add(s.substring(i, j+1));
                dfs(j + 1, part, s, res);
                part.remove(part.size() - 1);
            }
        }
    }
    private boolean isPali(String s, int l, int r) {
        while(l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

// t = O(n * 2n)
// s = O(n) if output include O(n * 2n)