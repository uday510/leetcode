class Solution {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        
        long l = 1, r = x;

        while (l < r) {
            long m = (l + r) >> 1;
            long v = m * m;

            if (v <= x) l = m + 1;
            else r = m;
        }

        return (int) l - 1;
    }
}