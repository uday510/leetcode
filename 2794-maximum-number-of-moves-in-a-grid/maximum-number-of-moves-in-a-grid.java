class Solution {
    int[][] dirs = {{-1,1}, {0,1}, {1,1}};
    int[][] dp;
    int N;
    int M;
    public int maxMoves(int[][] grid) {
        int max = 0;
        N = grid.length;
        M = grid[0].length;
        dp = new int[N][M];

        for (int[] arr : dp) 
            Arrays.fill(arr, -1);
        
        for (int i = 0; i < N; ++i) {
            max = Math.max(max, moves(i, 0, grid));
        }
        return max;
    }
    private int moves(int row, int col, int[][] grid) {
        if (dp[row][col] != -1) 
            return dp[row][col];
        
        int moved = 0;
        int moves = 0;

        for (int[] d : dirs) {
            int R = d[0] + row;
            int C = d[1] + col;

           if (R < 0 || R >= N || C < 0 || C >= M || grid[R][C] <= grid[row][col]) 
                continue;

            moves = Math.max(moves, moves(R,C,grid));
            moved = 1;
        }
        return dp[row][col] = moves + moved;
    }
}
