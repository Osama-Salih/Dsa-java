package backtracking.letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> res;
    private String[] digitsToChar;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        digitsToChar = new String[]{"", "", "abc", "def",
                "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrack(0, "", digits);
        return res;
    }
    private void backtrack(int i, String curStr, String digits) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }

        String chars = digitsToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray())
            backtrack(i + 1, curStr + c, digits);
    }
}
// t = O(n * 4n)
// s = O(n)