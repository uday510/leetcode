class Solution {
    int[][] DIRs = {
                 {0, 1}, {0, -1},
                 {-1, 0}, {1, 0},
                 {-1, -1}, {-1, 1},
                 {1, -1}, {1, 1}
                };
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];

            if (row == n-1 && col == n-1) return dist;

            for (int[] dir : DIRs) {
                int R = row + dir[0];
                int C = col + dir[1];

                if (R < 0 || R >= n || 
                    C < 0 || C >= n || 
                    visited[R][C] || grid[R][C] == 1
                    ) { continue; }

                visited[R][C] = true;
                queue.offer(new int[] {R, C, dist + 1});
            }
        }

        return -1;
    }
}