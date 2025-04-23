class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int time = -1, m = grid.length, n = grid[0].length, freshOranges = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) queue.offer(new int[] {i, j});
                if (grid[i][j] == 1) ++freshOranges;
            }
        }

        if (freshOranges == 0) return 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int R = dir[0] + curr[0];
                    int C = dir[1] + curr[1];

                    if (R < 0 || R >= m || C < 0 || C >= n || grid[R][C] != 1) continue;

                    grid[R][C] = 2;
                    --freshOranges;
                    queue.offer(new int[]{R, C});
                }
            }

            time++;
        }

        return freshOranges == 0 ? time : -1;
    }
}