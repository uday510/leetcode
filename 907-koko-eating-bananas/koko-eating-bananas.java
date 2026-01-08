class Solution {

    int[] piles;

    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;

        int l = 1, r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {

            int m = (l + r) >> 1;
            if (canEat(m, h)) r = m;
            else l = m + 1;
        }    

        return l;
    }

    private boolean canEat(int pHr, int rHrs) {
        int cHrs = 0;

        for (int pile : piles) {
            cHrs += Math.ceil((double) pile / pHr);
            if (cHrs > rHrs) return false;
        }

        return true;
    }
}