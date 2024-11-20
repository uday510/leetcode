class Solution {
    public int trailingZeroes(int n) {
        int num = n;
        int factor = 5;
        int count = 0;

        while ((num / factor)> 0) {
            count += (num / factor);

            num /= factor;
        }
        return count;
    }
}