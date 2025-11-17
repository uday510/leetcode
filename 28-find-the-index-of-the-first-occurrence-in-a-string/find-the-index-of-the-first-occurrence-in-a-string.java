class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();

        for (int i = 0; i < n; i++) {
            int j = i, k = 0;

            while (
                j < n && k < m && 
                haystack.charAt(j) == needle.charAt(k)
            ) {
                k++;
                j++;
            }

            if (k == m) return i;
        }

        return -1;
    }
}