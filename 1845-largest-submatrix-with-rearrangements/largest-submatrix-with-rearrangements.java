class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int maxArea = 0;
        int N = matrix.length;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (i > 0 && matrix[i][j] != 0) {
                    matrix[i][j] += matrix[i-1][j];
                }
            }
            int[] row = matrix[i].clone();
            Arrays.sort(row);
            int M = row.length;
            for (int j = 0; j < M; ++j) {
                maxArea = Math.max(maxArea, row[j]*(M-j));
            }
        }
        return maxArea;
    }
}