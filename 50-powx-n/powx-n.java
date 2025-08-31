class Solution {
    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }
    private double binaryExp(double base, long exp) {
        if (exp < 0) {
            exp = -1 * exp;
            base = 1.0 / base;
        }

        double res = 1;

        while (exp > 0) {

            if ((exp & 1L) == 1L) res *= base;

            base *= base;
            exp >>= 1;
        }
        
        return res;
    }
}