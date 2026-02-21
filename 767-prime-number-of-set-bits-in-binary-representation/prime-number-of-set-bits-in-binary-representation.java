class Solution {

    private static final Set<Integer> primes = new HashSet<>();
    static {
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);
    }
    public int countPrimeSetBits(int l, int r) {
        
        int cnt = 0;

        for (int i = l; i <= r; i++) {
            if (primes.contains(Integer.bitCount(i))) {
                cnt += 1;
            }
        }

        return cnt;
    }
}