class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num;

        while (l < r) {
            long m = l + ((r - l) >> 1);
            long cur = (long) (m * m);

            if (cur < num) l = m + 1;
            else r = m;
        }

        return l * l == num;
    }
}