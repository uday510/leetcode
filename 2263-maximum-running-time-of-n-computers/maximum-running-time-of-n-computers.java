class Solution {
    public long maxRunTime(int n, int[] B) {
        long l = 1, r = Arrays.stream(B).asLongStream().sum() / n;

        while (l < r) {
            long m = (l + r + 1) >>> 1;

            if (canRun(B, n, m)) l = m;
            else r = m - 1;
        }

        return l;
    }

    private boolean canRun(int[] B, int n, long req) {
        long total = 0;

        for (int b : B) total += Math.min((long) b, req);

        return total >= req * n;
    }
}