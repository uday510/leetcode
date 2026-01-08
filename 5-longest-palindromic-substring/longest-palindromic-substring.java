class Solution {

    String s;
    int n;

    public String longestPalindrome(String s) {
        int[] r = {0, 1};
        this.n = s.length();
        this.s = s;

        int[] o, e, c;

        for (int i = 0; i < n; i++) {
            o = getLen(i - 1, i + 1);
            e = getLen(i - 1, i);

            c = o[1] - o[0] > e[1] - e[0] ? o : e;
            r = c[1] - c[0] > r[1] - r[0] ? c : r;
        }

        return s.substring(r[0], r[1]);

    }

    private int[] getLen(int i, int j) {

        while (i > -1 && j < n && s.charAt(i) == s.charAt(j)) {
            i--; j++;
        }

        return new int[] {i + 1, j};
    }
}