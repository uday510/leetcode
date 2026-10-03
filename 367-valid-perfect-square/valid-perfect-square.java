class Solution {
    public boolean isPerfectSquare(int n) {
        long l = 1, r = n;

        while (l < r) {
            long m = l + ((r - l) >> 1);

            long cur = (long) (m * m);

            if (cur < n) l = m + 1;
            else r = m;
        }

        return l * l == n;
    }
}