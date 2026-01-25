package easy.mergeStringsAlternately;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0;

        while (i < Math.min(word1.length(), word2.length())) {
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i));
            i++;
        }

        if (word1.length() > word2.length()) {
            ans.append(word1.substring(i, word1.length()));
        }

        else {
            ans.append(word2.substring(i, word2.length()));
        }

        return ans.toString();
    }
}