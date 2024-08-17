class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        int maxI = 0;

        for (int j = 0; j < values.length; ++j) {
            max = Math.max(max, maxI + values[j] - j);
            maxI = Math.max(maxI, values[j] + j);
        }
        return max;
    }
}