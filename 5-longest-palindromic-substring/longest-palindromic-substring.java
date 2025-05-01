class Solution {
    public String longestPalindrome(String s) {
        int[] longest = new int[] {0, 1};

        for (int idx = 0; idx < s.length(); ++idx) {
            int[] odd = getPalindromicSubstringLength(idx - 1, idx + 1, s);
            int[] even = getPalindromicSubstringLength(idx - 1, idx, s);

            int[] curr = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            longest = curr[1] - curr[0] > longest[1] - longest[0] ? curr : longest;
        }

        return s.substring(longest[0], longest[1]);
    }

    private int[] getPalindromicSubstringLength (int i, int j, String s) {
        
        while (i < j && i > -1 && j < s.length()) {
            char ch1 = s.charAt(i), ch2 = s.charAt(j);
            if (ch1 != ch2) break;
            i--; j++;
        }

        return new int[] {i + 1, j};
    }
}