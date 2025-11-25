class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        long l = 1, r = x >> 1;

        while (l <= r) {
            long m = (l + r) >> 1;

            long v = m * m;
            if (v == x) return (int) m;

            if (v < x) l = m + 1;
            else r = m - 1;
        }

        return (int) r;
    }
}