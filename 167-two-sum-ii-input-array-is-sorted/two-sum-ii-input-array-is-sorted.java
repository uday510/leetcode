class Solution {
    public int[] twoSum(int[] A, int T) {
        
        int curSum;
        for (int i = 0, j = A.length - 1; i < j;) {
            
            curSum = A[i] + A[j];
            if (curSum == T) {
                return new int[] {i + 1, j + 1};
            } else if (curSum < T) {
                i++;
            } else {
                j--;
            }

        }

        return new int[] {-1, -1};
    }
}