class Solution {
    public int arraySign(int[] nums) {
        
        int count = 0;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            } 

            if (num < 0) {
               ++count;

               count %= 2;
            }
        }

        return count == 0 ? 1 : -1;
    }
}