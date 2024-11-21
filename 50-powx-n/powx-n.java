class Solution {
    public double myPow(double x, long n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return dfs(x, n);
    }
    private double dfs(double x, long n) {
        if (n <= 0) {
            return 1.0;
        }

        double halfPower = dfs(x, n / 2);

        double power = halfPower * halfPower;

        // odd
        if (n % 2 == 1) {
            power *= x;
        }

        return power;
    }
}