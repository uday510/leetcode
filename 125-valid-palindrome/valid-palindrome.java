class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {

            if (!Character.isLetterOrDigit(s.charAt(i))) i++;
            else if (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            else if (lower(s.charAt(i)) != lower(s.charAt(j))) return false;
            else {
                i++;
                j--;
            }

        }

        return true;
    }

    private char lower(char ch) {
        return Character.toLowerCase(ch);
    }
}