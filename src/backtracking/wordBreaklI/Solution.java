package backtracking.wordBreaklI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

private Set<String> wordSet;
private List<String> res;

public List<String> wordBreak(String s, List<String> wordDict) {
    wordSet = new HashSet<>(wordDict);
    res = new ArrayList<>();
    List<String> cur = new ArrayList<>();

    backtrack(s, 0, cur);
    return res;
}
private void backtrack(String s, int i, List<String> cur) {
    if (i == s.length()) {
        res.add(String.join(" ", cur));
        return;
    }

    for (int j = i; j < s.length(); j++) {
        String w = s.substring(i, j + 1);
        if (wordSet.contains(w)) {
            cur.add(w);
            backtrack(s, j + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
}