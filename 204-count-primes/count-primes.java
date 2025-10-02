class Solution {
    public int countPrimes(int n) {
        int[] primes = new int[n];

        for (int i = 2; i * i <= n; i++) {
            if (primes[i] == 1) continue; // not prime

            for (int j = i * i; j < n; j += i) {
                primes[j] = 1;
            }
        }

        int cnt = 0;

        for (int i = 2; i < n; i++) {
            cnt += primes[i] == 0 ? 1 : 0;
        }

        return cnt;
    }
}