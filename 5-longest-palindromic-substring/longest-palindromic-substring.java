class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        int[] l = {0, 1};

        for (int i = 0; i < n; i++) {
            int[] o = ok(i - 1, i + 1, s);
            int[] e = ok(i - 1, i, s);

            int[] c = o[1] - o[0] > e[1] - e[0] ? o : e;
            l = c[1] - c[0] > l[1] - l[0] ? c : l;
        }
        
        return s.substring(l[0], l[1]);
    }

    private int[] ok(int st, int en, String s) {

        while (
            st > -1 && en < s.length() &&
             s.charAt(st) == s.charAt(en)) {

            st--; en++;
        }

        return new int[] {st + 1, en};

    }

}
