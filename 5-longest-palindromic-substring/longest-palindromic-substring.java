class Solution {
    public String longestPalindrome(String s) {
        int[] longest = {0, 1};

        for (int i = 0; i < s.length(); ++i) {
            int[] odd = getLength(i - 1, i + 1, s);
            int[] even = getLength(i, i + 1, s);

            int[] current = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            longest = current[1] - current[0] > longest[1] - longest[0] ? current : longest;
        }

        return s.substring(longest[0], longest[1]);
    }

    private int[] getLength(int left, int right, String s) {

        while (left > -1 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }

            left--;
            right++;
        }

        return new int[]{left + 1, right};
    }
}
