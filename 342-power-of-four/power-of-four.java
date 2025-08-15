class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        return n > 1 && n % 4 == 0 && isPowerOfFour(n/4);
    }
}