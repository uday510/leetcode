class Solution {
    int M;
    int N;
    int[][] memo;

    public int minPathSum(int[][] grid) {
        M = grid.length;
        N = grid[0].length;

        memo = new int[M][N];

        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return dfs(0, 0, grid);
    }
    private int dfs(int rowIdx, int colIdx, int[][] grid) {
        if (rowIdx >= M || colIdx >= N) {
            return (int) 1e9 / 2;
        }

        if (rowIdx == M - 1 && colIdx == N - 1) {
            return grid[rowIdx][colIdx];
        }

        if (memo[rowIdx][colIdx] != -1) {
            return memo[rowIdx][colIdx];
        }

        int curr = grid[rowIdx][colIdx];

        int right = dfs(rowIdx, colIdx + 1, grid);
        int down = dfs(rowIdx + 1, colIdx, grid);
        
        return memo[rowIdx][colIdx] = Math.min(right, down) + curr;
    }
}