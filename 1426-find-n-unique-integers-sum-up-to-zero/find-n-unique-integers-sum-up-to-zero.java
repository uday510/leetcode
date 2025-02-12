class Solution {
    public int[] sumZero(int n) {
        
        int[] result = new int[n];
        
        int val = 1;
        for (int idx = 0; idx < n/2; ++idx) {
            result[idx] = val;
            result[n - idx - 1] = -val;
            ++val;
        }

        return result;
    }
}