class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {
            int m = (l + r) >> 1;

            if (canEat(m, piles, h)) r = m;
            else l = m + 1;
        }

        return l;
    }
    
    private boolean canEat(int k, int[] piles, int reqHrs) {
        int currHrs = 0;

        for (int pile : piles) {
            currHrs += Math.ceil((double) pile / k);
            if (currHrs > reqHrs) break;
        }

        return currHrs <= reqHrs;
    }
}