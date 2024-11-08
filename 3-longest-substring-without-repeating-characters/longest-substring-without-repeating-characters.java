class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j= 0;
        int N = s.length();
        int[] cnt = new int[128];
        int longest = 0;

        while (j < N) {
            cnt[s.charAt(j)]++;

            while (cnt[s.charAt(j)] > 1) {
                cnt[s.charAt(i++)]--;
            }
            longest = Math.max(longest, j-i+1);
            ++j;
        }
        return longest;
    }
}