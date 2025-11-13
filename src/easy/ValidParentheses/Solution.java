package easy.ValidParentheses;

import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of('(', ')', '[', ']', '{', '}');

        for (char c : s.toCharArray()) {
            if (String.valueOf(c).matches("[\\(\\[\\{]")) {
                stack.push(c);
            } else if (stack.isEmpty() || c != map.get(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
