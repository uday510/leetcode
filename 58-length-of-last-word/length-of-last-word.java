class Solution {
    public int lengthOfLastWord(String s) {
        
        int i = s.length() - 1;

        while (i > -1 && s.charAt(i) == ' ') i--;

        int len = 0;

        while (i > -1 && s.charAt(i) != ' ') {
            i--; len++;
        }

        return len;
    }
}