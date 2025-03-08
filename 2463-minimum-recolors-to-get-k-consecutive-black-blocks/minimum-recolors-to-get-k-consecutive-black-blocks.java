class Solution {
    private final char WHITE = 'W';
    public int minimumRecolors(String s, int k) {
        int min = 0;
        int cnt = 0;

        for (int idx = 0; idx < k; ++idx) {
            cnt += s.charAt(idx) == WHITE ? 1 : 0;
        }

        min = cnt;

        for (int idx = k; idx < s.length(); ++idx) {
            cnt += s.charAt(idx-k) == WHITE ? -1 : 0;
            cnt += s.charAt(idx) == WHITE ? 1 : 0;
            min = Math.min(min, cnt);
        }

        return min;
    }
}

