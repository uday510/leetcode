class Solution {
    public int minDifference(int[] arr) {
        int N = arr.length;
        
        if (N <= 4) {
            return 0;
        }
        
        java.util.Arrays.sort(arr);
        
        int minDiff = Integer.MAX_VALUE;
        
        
        for (int i = 0; i <= 3; i++) {
            minDiff = Math.min(minDiff, arr[N - 4 + i] - arr[i]);
        }
        
        return minDiff;
    }
}
