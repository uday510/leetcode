class Solution {
    public int minSpeedOnTime(int[] d, double hr) {
        
        int l = 1, r = 2;
        while (r < Integer.MAX_VALUE / 2 && !canReach(d, r, hr)) r <<= 1;

        while (l < r) {

            int m = l + ( (r - l) >> 1);

            if (!canReach(d, m, hr)) l = m + 1;
            else r = m;
        }

        return canReach(d, l, hr) ? l : -1;
    }

    private boolean canReach(int[] d, int m, double hr) {
        double cur = 0;

        for (int i = 0; i < d.length - 1; i++) {
            cur += (d[i] + m - 1) / m;
            if (cur > hr) return false;
        }

        cur += (double) d[d.length - 1] / m;

        return cur <= hr;
    }
}