class Solution {
    public int minCost(String colors, int[] time) {
        int min = 0, n = colors.length();

        for (int i = 0, j = i; i < n; i = j) {
            int cur = 0, max = 0;

            while (j < n && colors.charAt(i) == colors.charAt(j)) {
                cur += time[j];
                max = Math.max(max, time[j++]);
            }
            
            min += cur - max;
        }

        return min;
    }
}