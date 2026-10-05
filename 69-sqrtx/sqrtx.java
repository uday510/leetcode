class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        long cur;
        int m, l = 2, r = x / 2;

        while (l <= r) {
            m = l + ((r - l) >> 1);
            cur = (long) m * m;

            if (cur == x) return m;
            if (cur < x) l = m + 1;
            else r = m - 1;
        }

        return r;
    }
}