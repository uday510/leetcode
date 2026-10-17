class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] cnts = new int[128];
        int longest = 0, n = s.length();

        for (int i = 0, j = 0; j < n; j++) {
            cnts[s.charAt(j)]++;

            while (i < j && cnts[s.charAt(j)] > 1) {
                cnts[s.charAt(i++)] -= 1;
            }

            longest = Math.max(longest, j - i + 1);
        }

        return longest;
    }
}