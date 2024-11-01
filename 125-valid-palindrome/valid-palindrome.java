class Solution {
    public boolean isPalindrome(String s) {
        int i = 0; int j = s.length() - 1;

        while (i < j) {
            while (i < j && !isChar(s.charAt(i))) 
                ++i;

            while (i < j && !isChar(s.charAt(j))) 
                --j;

            if (lower(s.charAt(i++)) != lower(s.charAt(j--)))
                return false;
        }
        return true;
    }
    private boolean isChar(char c) {
        return Character.isLetterOrDigit(c);
    }
    private char lower(char c) {
        return Character.toLowerCase(c);
    }
}