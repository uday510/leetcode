class Solution {
    int[] sweetness;
    int k;
    public int maximizeSweetness(int[] sweetness, int k) {
        this.sweetness = sweetness;
        this.k = k;

        int l = 1, r = Arrays.stream(sweetness).sum() / (k + 1);
        int res = -1;

        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (canDivide(m)) {
                res = m;
                l = m + 1;
            }
            else r = m - 1;
        }

        return res;
    }

    private boolean canDivide(int limit) {
        int cuts = 0;
        int curr = 0;

        for (int s : sweetness) {
            curr += s;
            if (curr >= limit) { // atleast limit, we have cut int k + 1 such that all the 
            //  cuts have atleast limit
                curr = 0;
                cuts += 1;
            }
        }

        return cuts >= k + 1;
    }
}