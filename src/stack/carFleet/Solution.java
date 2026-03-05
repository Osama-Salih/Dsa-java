package stack.carFleet;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int [][]pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int []p : pair) {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }

//    public static int carFleet(int target, int[] position, int[] speed) {
//        int n = position.length;
//        double[][] cars = new double[n][2];
//
//        for (int i = 0; i < n; i++) {
//            cars[i][0] = position[i];
//            cars[i][1] = (double) (target - position[i]) / speed[i];
//        }
//
//        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
//
//        int count = 0;
//        double prevTime = 0;
//        for (double[] car : cars) {
//            if (car[1] > prevTime) {
//                count++;
//                prevTime = car[1];
//            }
//        }
//        return count;
//    }
    // t O(n log n)
    // s(n)
    // for both solutions
}
