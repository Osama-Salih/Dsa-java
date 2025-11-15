package easy.lengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.trim().lastIndexOf(" ");
        return s.trim().length() - (index + 1);
    }
}
