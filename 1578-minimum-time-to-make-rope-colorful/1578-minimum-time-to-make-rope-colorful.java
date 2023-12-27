class Solution {
    public int minCost(String colors, int[] times) {
        int N = colors.length();
        int res = 0;
        int prevIdx = 0;
        
        for (int i = 1; i < N; ++i) {
            char curr = colors.charAt(i);
            char prev = colors.charAt(prevIdx);
            if (curr != prev) {
                prevIdx = i;
            } else {
                if (times[prevIdx] < times[i]) {
                    res += times[prevIdx];
                    prevIdx = i;
                } else {
                    res += times[i];
                }
            }
        }
        return res;
    }
}