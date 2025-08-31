class Solution {
    public int countOdds(int low, int high) {
        long res = 0;
        if (low % 2 == 0) low = low + 1;
        while (low <= high) {
            // if (low % 2 == 1) {
            //     res++;
            // }
            res++;
            low += 2;
        }
        return (int) res;

        // if ( (low & 1) == 0 ) low++;

        // return low > high ? 0 : (high - low) / 2 + 1;
        
    }
}