class Solution {
    
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;

        for (int w : weights) {
            l = Math.max(l, w); // need max, if min choose cannot fit max
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
        int used = 1;

        for (int x : w) {
            if (x > m || used > d) return false;
            if (curr + x > m) {
                used++;
                curr = x;
            } else {
                curr += x;
            }
        }

        return used <= d;
    }

}