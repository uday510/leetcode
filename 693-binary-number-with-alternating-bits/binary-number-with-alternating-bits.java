class Solution {
    public boolean hasAlternatingBits(int n) {
        int p = n & 1;
        n >>= 1;
        
        while (n > 0) {
            int c = n & 1;

            if (p == c) return false;
            
            p = c;
            n >>= 1;
        }

        return true;
    }
}