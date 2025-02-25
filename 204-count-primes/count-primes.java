class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;

        int[] prime = new int [n + 1];

        int cnt = 0;
        for (int idx = 2; idx * idx < n; ++idx) {
            if (prime[idx] == 0) {
                for (int idx2 = idx * idx; idx2 <= n; idx2 += idx) {
                    prime[idx2] = 1;
                }
            }
        }

        for (int idx = 2; idx < n; ++idx) {
            if (prime[idx] == 0) cnt++;
        }

        return cnt;
    }
}