class Solution {
    public boolean lemonadeChange(int[] bills) {
       int[] cnt = new int[21];

       for (int bill : bills) {
            ++cnt[bill];
            int needed = bill-5;

            for (int denom : new int[]{20, 10, 5}) {
                while (needed >= denom && cnt[denom] > 0) {
                    needed -= denom;
                    --cnt[denom];
                }
            }
            if (needed > 0) 
                return false;
       }
       return true;
    }
}