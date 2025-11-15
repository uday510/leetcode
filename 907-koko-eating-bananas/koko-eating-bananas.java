class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {
            int m = (l + r) >> 1;

            if (canEat(piles, m, h)) r = m;
            else l = m + 1;
        }

        return l;
    }

    private boolean canEat(int[] piles, int perHr, int reqHrs) {
        int curHrs = 0;

        for (int pile : piles) {
            curHrs += Math.ceil((double) pile / perHr);
            if (curHrs > reqHrs) return false;
        }

        return curHrs <= reqHrs;
    }
}