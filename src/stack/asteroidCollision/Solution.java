package stack.asteroidCollision;

import java.util.Stack;

public class Solution {

    public int[] asteroidCollision(int []asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            while(!stack.empty() && a < 0 && stack.peek() > 0) {
                int diff = a + stack.peek();
                if (diff < 0) {
                    stack.pop();
                } else if (diff > 0) {
                    a = 0;
                } else {
                    a = 0;
                    stack.pop();
                }
            }
            if (a != 0) {
                stack.push(0);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();

    }
}
