class Solution {
    public int arraySign(int[] nums) {
        int numNegatives = 0;

        for (int num : nums) {
            if (num == 0) return 0;

            if (num < 0) { 
                numNegatives++;
                numNegatives %= 2;
            }
        }
        
        return numNegatives == 1 ? -1 : 1;
    }
}