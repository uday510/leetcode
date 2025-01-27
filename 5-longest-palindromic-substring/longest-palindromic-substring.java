class Solution {
    public String longestPalindrome(String s) {
        int[] curr = new int[]{0, 1};
        int[] longest = new int[]{0, 1};

        for (int idx = 0; idx < s.length(); ++idx) {
            int[] odd = getLength(idx - 1, idx + 1, s);
            int[] even = getLength(idx, idx + 1, s);

            curr = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            
            longest = curr[1] - curr[0] > longest[1] - longest[0] ? curr : longest;
        }

        return s.substring(longest[0], longest[1]);
    }

    private int[] getLength(int i, int j, String s) {

        while (i > -1 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                return new int[]{i + 1, j};
            }
            
            i--;
            j++;
        }

        return new int[]{i + 1, j};
    }
}