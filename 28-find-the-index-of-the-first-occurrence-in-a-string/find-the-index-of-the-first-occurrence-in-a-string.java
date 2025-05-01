class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        int j = 0;

        while (j < n) {
            int k = 0;
            while (k < m && (j + k) < n && needle.charAt(k) == haystack.charAt(j + k)) {
                System.out.println(j + " " + k);
                k++;
            }

            if (k == m) return j;

            j++;
        }

        return -1;
    }
}