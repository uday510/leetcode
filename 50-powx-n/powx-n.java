class Solution {
    public double myPow(double x, long n) {
        if (n < 0) {
            x = 1/x;
            n = Math.abs(n);
        }
        return dfs(x, n);
    }
    public double dfs(double x, long n) {
      if (n <= 0) return 1.0;
      double val = dfs(x, n/2);
      val *= val;
      if (n%2 != 0) {
        val *= x;
      }
      return val;
    }
}