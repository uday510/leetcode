class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maximumSquare = 0;

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (matrix[row][col] == '0') continue;
                int left = (col > 0) ? dp[row][col-1] : 0;
                int up = (row > 0) ? dp[row-1][col] : 0;
                int diag = (row > 0 && col > 0) ? dp[row-1][col-1] : 0;
                dp[row][col] = Math.min(left, Math.min(up, diag)) + 1;
                maximumSquare = Math.max(dp[row][col], maximumSquare);
            }
            System.out.println(Arrays.toString(dp[row]));
        }

        return maximumSquare * maximumSquare;
    }
}