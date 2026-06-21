class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int f0 = 0, f1 = 1;

        for (int f = 2; f <= n; f++) {
            int fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }

        return f1;
    }
}
