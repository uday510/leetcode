class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int i = 0, longest = 0, n = s.length();

        for (int j = 0; j < n; j++) {
            freq[s.charAt(j)]++;

            while (freq[s.charAt(j)] > 1) freq[s.charAt(i++)]--;
            longest = Math.max(longest, j - i + 1);
        }

        return longest;
    }
}