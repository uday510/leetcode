class Solution {
    
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;

        for (int w : weights) {
            l = Math.min(l, w);
            r += w;
        }

        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (canShip(weights, m, days)) r = m;
            else l = m + 1;
        }

        return l;
    }

    private boolean canShip(int[] w, int m, int d) {
        int curr = 0;
        int days = 1;

        for (int i = 0; i < w.length && days <= d; ++i) {
            if (w[i] > m) return false;
            if (curr + w[i] > m) {
                curr = w[i];
                days++;
            } else curr += w[i];

        }

        return days <= d;
    }

}