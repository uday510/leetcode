class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length(), ones = 0;
        int mn = n + 1, st = -1;

        for (int l = 0, r = 0; r < n; r++) {
            ones += s.charAt(r) == '1' ? 1 : 0;

            while (ones == k) {
                int len = r - l + 1;

                if (s.charAt(l) == '1' &&
                (len < mn || 
                (len == mn && s.substring(l, r + 1).compareTo(s.substring(st, st + mn)) < 0))) {
                    mn = len;
                    st = l;
                }

                ones += s.charAt(l) == '1' ? -1 : 0;
                l++;
            }
        }

        return st == -1 ? "" : s.substring(st, st + mn);
    }

}
