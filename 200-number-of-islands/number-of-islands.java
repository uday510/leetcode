class Solution {

    private final int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private char[][] grid;
    private int m, n;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    bfs(i, j);
                }
            }
        }

        return numIslands;
    }

    private void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];

                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') continue;

                grid[x][y] = '0';
                queue.offer(new int[]{x, y});
            }
        }
    }
}