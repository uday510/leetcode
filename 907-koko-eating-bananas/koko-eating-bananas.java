class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {
            int m = (l + r) >> 1;

            if (!canEat(piles, m, h)) l = m + 1;
            else r = m;
        }

        return l;
    }

    private boolean canEat(int[] piles, int k, int reqHrs) {
        int curHrs = 0;

        for (int pile : piles) {
            // curHrs += (int) Math.ceil((double) pile / k);
            curHrs += ((pile + k - 1 )/ k);
            if (curHrs > reqHrs) return false;
        }

        return curHrs <= reqHrs;
    }
}
