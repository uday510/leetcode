class Solution {
    public int smallestDivisor(int[] arr, int t) {
        int l = 1, r = 1;
        for (int x : arr) r = Math.max(r, x);

        while (l < r) {

            int m = l + ( (r - l) >> 1 );

            if (!isValid(arr, m, t)) l = m + 1; // increase m, so it will decrease threshold
            else r = m;
        }

        return l;
    }

    private boolean isValid(int[] arr, int b, int limit) {
        int cur = 0;

        for (int a : arr) {
            if (cur > limit) break;
            cur += (a + b - 1) / b;
        }

        return cur <= limit;
    }
}