class Solution {

    private final static int[][] DIRs = {
        {0, 1}, {1, 0}, {-1, 0}, {0, -1},
        {-1, -1}, {1, -1}, {-1, 1}, {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        if (grid[0][0] == 1) 
            return -1;
        
        grid[0][0] = 2;
        queue.offer(new int[] {0, 0, 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], w = cur[2];

            if (x == n - 1 && y == m - 1) {
                return w;
            }

            for (int[] nxt : DIRs) {
                int nx = nxt[0] + x;
                int ny = nxt[1] + y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] > 0) {
                    continue;
                }

                grid[nx][ny] = 2;
                queue.offer(new int[] {nx, ny, w + 1});
            }
        }

        return -1;
    }

}