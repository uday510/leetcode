class Solution {
    public String longestPalindrome(String s) {
        int[] longest = {0, 1};
        int[] current = longest;

        for (int idx = 0; idx < s.length(); ++idx) {
            int[] odd = getPalindromeLength(idx - 1, idx + 1, s);
            int[] even = getPalindromeLength(idx, idx + 1, s);

            current = odd[1] - odd[0] > even[1] - even[0] ? odd : even;

            longest = current[1] - current[0] > longest[1] - longest[0] ? current : longest;
        }


        return s.substring(longest[0], longest[1]);
    }

    private int[] getPalindromeLength(int leftIdx, int rightIdx, String s) {
        while (leftIdx > -1 && rightIdx < s.length()) {
            if (s.charAt(leftIdx) != s.charAt(rightIdx)) {
                break;
            }
            --leftIdx;
            ++rightIdx;
        }

        return new int[] {leftIdx + 1, rightIdx};
    }
}