class Solution {

    private final char SPACE = ' ';

    public int lengthOfLastWord(String s) {
        int n = s.length(), i = n - 1;

        while (i > -1 && s.charAt(i) == SPACE) i--;

        int len = 0;
        while (i > -1 && s.charAt(i) != SPACE) {
            len++; i--;
        }

        return len;
    }
}