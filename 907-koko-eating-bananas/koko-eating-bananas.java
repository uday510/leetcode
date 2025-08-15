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

        for (int i = 0; i < piles.length && reqHrs >= 0; ++i) {
            reqHrs -= Math.ceil((double) piles[i] / k);
        }

        return reqHrs >= 0;
    }
}