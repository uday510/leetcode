class Solution {
    public String longestPalindrome(String s) {
        int[] longest = {0, 1};
        int[] current = {0, 1};


        for (int idx = 0; idx < s.length(); ++idx) {

            int[] odd = lps(idx - 1, idx + 1, s);
            int[] even = lps(idx, idx + 1, s);

            current = odd[1] - odd[0] > even[1] - even[0] ? odd : even;

            longest = current[1] - current[0] > longest[1] - longest[0] ? current : longest;
        }

        /// babad

        return s.substring(longest[0], longest[1]);
    }

    private int[] lps(int leftIdx, int rightIdx, String s) {

            while (leftIdx > -1 && rightIdx < s.length()) {
                if (s.charAt(leftIdx) != s.charAt(rightIdx)) {
                    return new int[] {leftIdx + 1, rightIdx};
                }
                leftIdx--;
                rightIdx++;
            }

        return new int[] {leftIdx + 1, rightIdx};
    }
}

/**
             d a  b a c

 */

 // cbbd
 