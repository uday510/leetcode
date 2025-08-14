class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for (int w : weights) {
            l = Math.min(w, l);
            r += w;
        }

        while (l < r) {
            int m = (l + r) >> 1;
            if (canShip(weights, m, days)) r = m;
            else l = m + 1;
        }

        return l;
    }

    private boolean canShip(int[] weights, int perDayWeight, int days) {
        int currDays = 1;
        int currWeight = 0;

        for (int w : weights) {
            
            if (w > perDayWeight) return false;

            if (currWeight + w > perDayWeight) {
                currDays += 1;
                currWeight = w;
            } else currWeight += w;
            
            if (currDays > days) return false;
        }

        return currDays <= days;
    }
}