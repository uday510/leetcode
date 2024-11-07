class Solution {
    public int largestCombination(int[] candidates) {
       int[] arr = new int[24];
       int max = 0;

       for (int i = 0; i < 24; ++i) {
            for (int c : candidates) {
                int cnt = c & (1 << i);
                arr[i] += cnt != 0 ? 1 : 0;
                max = Math.max(max, arr[i]);
            }
       }
       return max;
    }
}