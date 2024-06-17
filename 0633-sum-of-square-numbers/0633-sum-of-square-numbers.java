class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        
        for (; left <= right;) {
            long curr =  (long) left*left + (long) right*right;
            
            if (curr == c) {
                return true;
            }
            if (curr < c) 
                ++left;
            else 
                --right;
        }
        
        return false;
    }
}