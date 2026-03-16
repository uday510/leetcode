class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] cnt = new int[128];
        int longest = 0;

        for (int i = 0, j = 0; j < n; j++) {
            cnt[s.charAt(j)]++;

            while (cnt[s.charAt(j)] > 1) {
                cnt[s.charAt(i++)]--;
            }

            longest = Math.max(longest, j - i + 1);
        }
        return longest;
    }
}