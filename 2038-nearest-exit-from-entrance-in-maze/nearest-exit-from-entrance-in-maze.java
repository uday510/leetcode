class Solution {

    private static int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public int nearestExit(char[][] maze, int[] en) {
        
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> queue = new ArrayDeque<>();
        vis[en[0]][en[1]] = true;
        queue.offer(new int[] {en[0], en[1], 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], w = cur[2];
            
            for (int[] nxt : DIRs) {
                int nx = nxt[0] + x, ny = nxt[1] + y;

                if (!isValid(nx, ny, n, m) || vis[nx][ny] || maze[nx][ny] != '.')
                    continue;

                if (isExit(nx, ny, n, m))
                    return w + 1;
                
                vis[nx][ny] = true;
                queue.offer(new int[] {nx, ny, w + 1});
            }
        }

        return -1;
    }

    private boolean isExit(int x, int y, int n, int m) {
        return isValid(x, y, n, m) && isBoundary(x, y, n, m);
    }

    private boolean isValid(int x, int y, int n, int m) {
        return x > -1 && x < n && y > -1 && y < m;
    }

    private boolean isBoundary(int x, int y, int n, int m) {
        
        if (x == 0 || x == n - 1)
            return true;
        
        return (y == 0 || y == m - 1);
    }
}