class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            
            while (i < j && !isChar(charAt(s,i)))
                ++i;
            while (i < j && !isChar(charAt(s,j)))
                --j;

            if (lower(charAt(s,i++)) != lower(charAt(s,j--)))
                return false;  
        } 
        return true;
    }
    private boolean isChar(char c) {
        return Character.isLetterOrDigit(c);
    }
    private char charAt(String s, int i) {
        return s.charAt(i);
    }
    private char lower(char c) {
        return Character.toLowerCase(c);
    }
}