class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 1, r = 1;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }

        while (l < r) {

            int m = l + ((r - l) >> 1);

            if (!canShip(m, weights, days)) l = m + 1; // increase load
            else r = m;
        }

        return l;
    }

    private boolean canShip(int loadPerDay, int[] weights, int days) {
        int cur = 0, d = 1;

        for (int w : weights) {
            if (cur + w > loadPerDay) {
                d++;
                cur = 0;
            }

            cur += w;
            if (d > days) return false;

        }

        return true;
    }
}