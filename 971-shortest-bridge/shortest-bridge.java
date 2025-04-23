class Solution {

    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    Queue<int[]> queue;
    int n;
    boolean[][] visited;
    int[][] grid;
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        visited = new boolean[n][n];
        queue = new ArrayDeque<>();
        this.grid = grid;

        boolean found = false;
        for (int i = 0; i < n && !found; ++i) {
            for (int j = 0; j < n && !found; ++j) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    found = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : dirs) {
                int i = curr[0] + dir[0];
                int j = curr[1] + dir[1];
                int d = curr[2];

                if (isOutOfBounds(i, j) || isVisited(i, j)) continue;

                if (grid[i][j] == 1) return d;

                visited[i][j] = true;
                queue.offer(new int[]{i, j, d + 1});
            }
        }

        return -1;
    }
    
    private void dfs(int i, int j) {
        if (isOutOfBounds(i, j) || grid[i][j] == 0 || isVisited(i, j)) return;

        queue.offer(new int[]{i, j, 0});
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int nextI = dir[0] + i;
            int nextJ = dir[1] + j;

            dfs(nextI, nextJ);
        }
    }
    
    private boolean isOutOfBounds(int i, int j) {
        return (i < 0 || i >= n || j < 0 || j >= n);
    }

    private boolean isVisited(int i, int j) {
        return visited[i][j];
    }
}