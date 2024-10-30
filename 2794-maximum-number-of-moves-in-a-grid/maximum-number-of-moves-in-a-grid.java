// class Solution {
//     int[][] dirs = {{-1,1}, {0,1}, {1,1}};
//     int N;
//     int M;
//     public int maxMoves(int[][] grid) {
//         int max = 0;
//         N = grid.length;
//         M = grid[0].length;
//         for (int i = 0; i < N; ++i) {
//             max = Math.max(max, moves(i, 0, grid));
//         }
//         return max;
//     }
//     private int moves(int row, int col, int[][] grid) {
//         int moved = 0;
//         int moves = 0;

//         for (int[] d : dirs) {
//             int R = d[0] + row;
//             int C = d[1] + col;

//             if (R < 0 || R > N-1 || C < 0 || C > M-1) 
//                 continue;

//             moves = Math.max(moves, moves(R,C,grid));
//             moved = 1;
//         }

//         return moves + moved;
//     }
// }

class Solution {
    public int maxMoves(int[][] grid) {
        int max = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] arr : dp) 
            Arrays.fill(arr, -1);

        for (int i = 0; i < grid.length; ++i) {
            max = Math.max(max, moves(i, 0, grid, dp));
        }
        return max;
    }
    private int moves(int row, int col, int[][] grid, int[][] dp) {
        if (row < 0 || row >= grid.length || col >= grid[0].length)
            return 0;

        if (dp[row][col] != -1) 
            return dp[row][col];

        int m1 = 0;
        int m2 = 0;
        int m3 = 0;
        int moved = 0;

        if (row-1 > -1 && col + 1 < grid[0].length 
            && grid[row-1][col+1] > grid[row][col]) {

            m1 = moves(row-1, col+1, grid, dp);
            moved = 1; 
        }

        if (col + 1 <  grid[0].length && grid[row][col+1] > grid[row][col]) {
            m2 = moves(row, col + 1, grid, dp);
            moved = 1;
        }

        if (row + 1 < grid.length && col + 1 < grid[0].length && 
            grid[row + 1][col + 1] > grid[row][col]) {
                m3 = moves(row+1, col+1, grid, dp);
                moved = 1;
        }

        return dp[row][col] = Math.max(m1, Math.max(m2, m3)) + moved;
    }
}