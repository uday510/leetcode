class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int minBananasPerHr = 1;
        int maxBananasPerHr = Arrays.stream(piles).max().getAsInt();

        while (minBananasPerHr < maxBananasPerHr) {

            int k = (minBananasPerHr + maxBananasPerHr) >> 1;

            if (canEatAllBananasWithKPerHr(piles, k, h)) maxBananasPerHr = k; // reduce time
            else minBananasPerHr = k + 1;
        }

        return minBananasPerHr;
    }
    private boolean canEatAllBananasWithKPerHr(int[] piles, int k, int reqHrs) {
        int currHrs = 0;

        for (int pile : piles) {
            currHrs += (int) Math.ceil(( (double) pile / k));
            if (currHrs > reqHrs) return false;
        }

        return currHrs <= reqHrs;
    } 
}