class Solution {
    public int[] closestPrimes(int left, int right) {
        int min = Integer.MAX_VALUE;
        int[] result = {-1, -1};
        int last = -1;
        left = Math.max(2, left);

        for (; left <= right; ++left) {
            if (!isPrime(left)) {
                continue;
            }

            if (last != -1) {
                if ((left - last < result[1] - result[0]) || result[0] == -1 && result[1] == -1) {
                    result[0] = last;
                    result[1] = left;
                }
            }

            last = left;
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