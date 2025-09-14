class Solution {
    final static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int n, m;
    char[][] grid;
    public int numIslands(char[][] grid) {
        int islands = 0;
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    bfs(i, j);
                }
            }
        }

        return islands;
    }

    private void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{i, j});
        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            for (int[] dir : dirs) {
                int dx = dir[0] + x, dy = dir[1] + y;

                if (dx < 0 || dx >= n || dy < 0 || dy >= m || grid[dx][dy] == '0') continue;

                grid[dx][dy] = '0';
                queue.offer(new int[] {dx, dy});
            }
        }
    }

}