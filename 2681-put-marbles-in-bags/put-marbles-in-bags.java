class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] p = new int[n - 1];

        for (int i = 0; i < n - 1; ++i) {
            p[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(p);


        long ans = 0l;

        for (int i = 0; i < k - 1; ++i) {
            ans += p[p.length - 1 - i] - p[i];
        }

        return ans;

    }
}
