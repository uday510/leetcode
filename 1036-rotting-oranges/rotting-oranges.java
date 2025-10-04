class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0, n = grid.length, m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) queue.offer(new int[] {i, j});
            }
        }

        if (fresh == 0) return 0;
        int t = -1;

        while (!queue.isEmpty()) {
            t++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (Math.abs(dx) + Math.abs(dy) != 1) continue;
                        int nx = cur[0] + dx, ny = cur[1] + dy;

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] != 1) continue;

                        queue.offer(new int[]{nx, ny});
                        grid[nx][ny] = 2;
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? t : -1;
    }
}