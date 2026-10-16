class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] cnts = new int[128];
        int longest = 0;

        for (int i = 0, j = 0; j < n; j++) {
            cnts[s.charAt(j)]++;

            while (i < j && cnts[s.charAt(j)] > 1) {
                cnts[s.charAt(i)] -= 1;
                i++;
            }

            longest = Math.max(longest, j - i + 1);
        }

        return longest;
    }
}