class Solution {
    public boolean isPalindrome(String s) {
        
        int i = 0, j = s.length() - 1;

        while (i < j) {

            if (!isAlpha(s.charAt(i))) i++;
            else if (!isAlpha(s.charAt(j))) j--;
            else if (lower(s.charAt(i)) != lower(s.charAt(j))) break;
            else {
                i++; j--;
            }
        }

        return i >= j;
    }

    private boolean isAlpha(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    private char lower(char ch) {
        return Character.toLowerCase(ch);
    }
}