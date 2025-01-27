class Solution {
    public String longestPalindrome(String s) {
        int[] current = new int[]{0, 1};
        int[] longest = new int[]{0, 1};

        for (int idx = 0; idx < s.length(); ++idx) {
            int[] odd = getLength(idx - 1, idx + 1, s);
            int[] even = getLength(idx, idx + 1, s);

            if (odd[1] - odd[0] > even[1] - even[0]) {
                current = odd;
            } else {
                current = even;
            }
            
            if (current[1] - current[0] > longest[1] - longest[0]) {
                longest = new int[]{current[0], current[1]};
            }
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