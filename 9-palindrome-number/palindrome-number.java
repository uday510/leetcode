class Solution {
    public boolean isPalindrome(int x) {
        int num = x;
        int ans = 0;

        while (num > 0) {
            ans *= 10;
            ans += (num % 10);
           
            num /= 10;
        }

        return x == ans;
    }
}