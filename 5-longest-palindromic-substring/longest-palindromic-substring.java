class Solution {
    public String longestPalindrome(String s) {
        int[] longest = {0, 1};


        for (int i = 0; i < s.length(); ++i) {
            int[] odd = len(i - 1, i + 1, s);
            int[] even = len(i, i + 1, s);

            int[] curr = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            longest = curr[1] - curr[0] > longest[1] - longest[0] ? curr : longest;
        }

        return s.substring(longest[0], longest[1]);
    }

    private int[] len(int i, int j, String s) {

        while (i > -1 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) 
                break;

            i--;
            j++;
        }

        return new int[]{i + 1, j};
    }
}