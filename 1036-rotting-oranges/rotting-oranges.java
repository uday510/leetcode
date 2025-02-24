class Solution {

    private final int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private boolean[][] visited;
    private int m;
    private int n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int freshOranges = 0;
        int minutes = -1;
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[m][n];
        
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                int curr = grid[row][col];
                if (curr == 2) {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                } else if (curr == 1) {
                    ++freshOranges;
                }
            }
        }
        
        if (freshOranges == 0) return 0;
        queue.offer(new int[]{-1, -1});
        
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

            if (arr[0] == -1 && arr[1] == -1) {
                ++minutes;
                if (!queue.isEmpty()) {
                    queue.offer(new int[]{-1, -1});
                }
            }

            for (int[] dir : dirs) {
                int R = dir[0] + arr[0];
                int C = dir[1] + arr[1];

                if (!isValid(R, C, grid)) continue;

                queue.offer(new int[]{R, C});
                visited[R][C] = true;
                --freshOranges;
            }
        }
        
        return freshOranges == 0 ? minutes : -1;
    }
    private  boolean isValid(int R, int C, int[][] grid) {
        return !(R < 0 || R >= m || C < 0 || C >= n || grid[R][C] == 0 || visited[R][C]);
    }
}