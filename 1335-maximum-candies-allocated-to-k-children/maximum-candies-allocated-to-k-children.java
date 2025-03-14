class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 0, right = (int) 1e7;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (canAllocate(candies, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public boolean canAllocate(int[] candies, int mid, long k) {
        long sum = 0;

        for (int i = 0; i < candies.length; ++i) {
            sum += candies[i] / mid;
        }

        return sum >= k;
    }
}