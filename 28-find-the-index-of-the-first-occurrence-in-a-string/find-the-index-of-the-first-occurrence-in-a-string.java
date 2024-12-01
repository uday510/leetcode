class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();

        for (int windowStart = 0; windowStart <  n - m + 1; ++windowStart) {
            
            int idx = 0;
            while (idx < m && haystack.charAt(windowStart + idx) == needle.charAt(idx)) {
                ++idx;
            }

            if (idx == m) {
                return windowStart;
            }
        }

        return -1;
    }
}