class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timeline = new int[1001];

        for (int[] trip : trips) {
            int from = trip[1];
            int to = trip[2];
            timeline[from] += trip[0];
            timeline[to] -= trip[0];
        }

        int curr = 0;
        for (int val : timeline) {
            if (curr > capacity) return false;
            curr += val;
        }

        return true;
    }
}