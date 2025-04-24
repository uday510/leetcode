class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = (left + right) >> 1;

            if (!canKokoEat(piles, mid, h)) 
                left = mid + 1;  // increase time
            else right = mid;
        }
        return left;
    }

    private boolean canKokoEat(int[] piles, int numPerHr, int requiredHrs) {
        int currHrs = 0;

        for (int pile : piles) {
            currHrs += Math.ceil((double) pile / numPerHr);
        }

        return currHrs <= requiredHrs;
    }
}