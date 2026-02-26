package stack.evaluateReversePolishNotation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String op = "+-*/";

        for (String c : tokens) {
            if (op.contains(c)) {

                int b = stack.pop();
                int a = stack.pop();

                char charOp = op.charAt(op.indexOf(c));
                int res = getResult(a, b, charOp);
                stack.push(res);

            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
    public int getResult(int a, int b, char charOp) {
        return switch (charOp) {
            case '+' -> a + b;
            case '*' -> a * b;
            case '-' -> a - b;
            case '/' -> a / b;
            default -> 0;
        };
    }
}
