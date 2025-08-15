class Solution {
    int[] sweetness;
    int k;
    public int maximizeSweetness(int[] sweetness, int k) {
        this.sweetness = sweetness;
        this.k = k;

        int l = 1, r = (int) 1e9 / (k + 1) + 1;

        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (canDivide(m)) {
                l = m + 1;
            }
            else r = m;
        }

        return r - 1;
    }

    private boolean canDivide(int limit) {
        int cuts = 0;
        int curr = 0;

        for (int s : sweetness) {
            curr += s;
            if (curr >= limit) {
                curr = 0;
                cuts += 1;
            }
        }

        return cuts >= k + 1;
    }
}