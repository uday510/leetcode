class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        
        int idx1, idx2, len1, len2;
        idx1 = idx2 = 0;
        len1 = str1.length();
        len2 = str2.length();

        while (idx1 < len1 && idx2 < len2) {

            char c1 = str1.charAt(idx1);
            char nextC1 = (char) ((c1 - 'a' + 1) % 26 + 'a');
            char c2 = str2.charAt(idx2);

            if (c1 == c2 || nextC1 == c2) {
                ++idx2;
            } 
            
            ++idx1;
        }

        return idx2 == len2;
    }
}