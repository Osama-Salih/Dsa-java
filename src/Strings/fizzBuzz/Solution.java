package Strings.fizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> strList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                strList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                strList.add("Fizz");
            } else if (i % 5 == 0) {
                strList.add("Buzz");
            } else {
                strList.add(String.valueOf(i));
            }
        }
        return strList;
    }
}
