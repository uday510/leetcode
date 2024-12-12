class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        long left = 1;
        long right = x;

        while (left < right) {
            long mid = (left + right) >> 1;

            long val = mid * mid;

            if ((int) val == x) {
                return (int) mid;
            }

            if (val < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) left - 1;
    }
}