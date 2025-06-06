class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int largest = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                char ch = matrix[i][j];
                if (ch == '0') continue;
                int left = 0, up = 0, dia = 0;

                if (i > 0) up = dp[i - 1][j];
                if (j > 0) left = dp[i][j - 1];
                if (i > 0 && j > 0) dia = dp[i - 1][j - 1];

                dp[i][j] = Math.min(left, Math.min(up, dia)) + 1;

                largest = Math.max(largest, dp[i][j]);
            }

            System.out.println(Arrays.toString(dp[Math.max(0, i - 1)]));
        }

        return largest * largest;
    }
}