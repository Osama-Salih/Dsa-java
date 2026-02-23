package stack.baseballGame;

import java.util.Stack;

public class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("C") && stack.size() >= 1) {
                stack.pop();
            } else if (operations[i].equals("D") && stack.size() >= 1) {
                stack.push(2 * stack.peek());
            } else if (operations[i].equals("+") && stack.size() >= 2){
                int prev = stack.get(stack.size() - 2);
                int last = stack.peek();
                stack.push(prev + last);
            } else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            sum += stack.get(i);
        }
        return sum;
    }
}
