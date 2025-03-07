class Solution {
    public int[] closestPrimes(int left, int right) {
        int min = (int) 1e6;
        int[] result = {-1, -1};
        int lastPrime = -1;
        left = Math.max(2, left);

        for (; left <= right; ++left) {
            if (!isPrime(left)) {
                continue;
            }

            if (lastPrime != -1) {
                if ((left - lastPrime < result[1] - result[0]) ||
                    result[0] == -1 && result[1] == -1) {
                    result[0] = lastPrime;
                    result[1] = left;
                }
            }

            lastPrime = left;
        }

        return result;
    }
    private boolean isPrime(int num) {
        for (int curr = 2; curr <= (int) Math.sqrt(num); ++curr) {
            if (num % curr == 0) {
                return false;
            }
        }

        return true;
    }
}