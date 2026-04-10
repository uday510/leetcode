class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles) r = Math.max(r, pile);

        while (l < r) {

            int m = l + ((r - l) >> 1);
            
            if (!canEat(m, h, piles)) l = m + 1;
            else r = m;
        }

        return l;
    }

    private boolean canEat(int perHr, int hrs, int[] piles) {

        int total = 0;

        for (int pile : piles) {

            total += Math.ceil(( (double) pile / perHr));

            if (total > hrs) return false;
        }

        return true;
    }
}