class Solution {
    public int arrangeCoins(int n) {
        if (n <= 1) return n;

        long l = 1, r = n;

        while (l < r) {
            long m = l + ( (r - l) >> 1);

            long coins = (long) ( m * (m + 1) / 2);

            if (coins == n) return (int) m;

            if (coins < n) l = m + 1;
            else r = m;
        }

        long cur = (long) (l * (l + 1) / 2);

        if (cur == n) return (int) l;

        return (int) l - 1;
    }
}