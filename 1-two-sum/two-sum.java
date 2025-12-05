class Solution {
    public int[] twoSum(int[] A, int T) {

        
        // i = 0, n
        // j = i + 1, n

        for (int i = 0, n = A.length; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (A[i] + A[j] == T) return new int[] {i, j};
            }
        }

        return new int[] {-1, -1};
    }
}

// [2,7,11,15]