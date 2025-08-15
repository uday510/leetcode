class Solution {

    int[] dist;
    int n;
    double hrs;

    public int minSpeedOnTime(int[] dist, double hour) {
        this.dist = dist;
        this.n = dist.length;
        hrs = hour;

        int l = 1;
        int r = 1;
        while (!canReach(r)) r <<= 1;

        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (canReach(m)) r = m;
            else l = m + 1;
        }

        return canReach(l) ? l : -1;
    }

    private boolean canReach(int k) {
        double h = 0.0;

        for (int i = 0; i < n - 1; ++i) {
            int d = dist[i];
            h += (d + k - 1) / k;
        }

        h += (double) dist[n - 1] / k;

        return h <= hrs;
    }
}