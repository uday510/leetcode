class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(reverse(n) - n);
    }

    private int reverse(int num) {
        int cur = 0;

        while (num > 0) {
            cur = (cur * 10) + num % 10;
            num /= 10;
        }
        
        return cur;
    }
}