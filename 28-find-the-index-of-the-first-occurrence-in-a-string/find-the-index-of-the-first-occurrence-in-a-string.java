class Solution {
    public int strStr(String h, String ne) {
        
        int n = h.length(), m = ne.length();

        for (int i = 0; i < n; i++) {
            int j = i, k = 0;

            while (
                j < n && k < m 
                && h.charAt(j) == ne.charAt(k)
            ) {
                j++;
                k++;
            }

            if (k == m) return i;
        }

        return -1;
    }
}