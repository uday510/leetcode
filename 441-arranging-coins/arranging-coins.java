class Solution {
    public int arrangeCoins(int n) {
        if (n <= 1) return n;
        
        long l = 1;
        long r = n;
        long num = n;

        while (l < r) {
            long m = (l + r) >> 1;
            long coins = (long) (m * (m + 1) / 2);

            if (coins == n) return (int) m;

            if (coins < n) l = m + 1;
            else r = m;
        }

        return (int) l - 1;
    }
}

// ( n * ( n + 1) / 2)
// ( 4 * 5 / 2;)

// 1 + 2 + 3 + 4 ,,, 

// 