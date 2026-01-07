class Solution {
    public int lengthOfLastWord(String s) {
        
        int n = s.length(), i = n - 1;

        while (i > -1 && s.charAt(i) == ' ') i--;

        int len = 0;
        while (i > -1 && s.charAt(i) != ' ') {
            len++; i--;
        }

        return len;
    }
}