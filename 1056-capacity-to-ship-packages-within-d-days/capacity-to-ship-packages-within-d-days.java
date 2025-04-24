class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while (left < right) {
            int mid = (left + right) >> 1;

            if (!canShip(weights, days, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private boolean canShip(int[] weights, int days, int req) {
        int curr = 1;
        int weight = 0;

        for (int idx = 0; idx < weights.length; ++idx) {
            weight += weights[idx];
            if (weight > req) {
                curr++;
                weight = weights[idx];
            }
        }
        return curr <= days;
    }
}