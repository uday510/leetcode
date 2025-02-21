class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[128];

        int start = 0;
        int end = 0;
        int len = s.length();
        int longest = 0;

        while (end < len) {

            ++cnt[s.charAt(end)];

            while (start < end && cnt[s.charAt(end)] > 1) {
                --cnt[s.charAt(start++)];
            }

            int current = (end - start + 1);
            longest = Math.max(longest, current);
            ++end;
        }

        return longest;
    }
}