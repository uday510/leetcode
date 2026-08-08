class Solution {
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
        
        int n = maze.length, m = maze[0].length;
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> queue = new ArrayDeque<>();
        vis[entrance[0]][entrance[1]] = true;
        queue.offer(new int[] {entrance[0], entrance[1], 0});
        
        int dx, dy, nx, ny, w;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            dx = cur[0]; dy = cur[1]; w = cur[2];
            
            if (w != 0 && isBoundary(dx, dy, n, m)) 
                return w;
            
            for (int[] dir : dirs) {
                nx = dx + dir[0];
                ny = dy + dir[1];
                
                if (!isValid(nx, ny, n, m, vis, maze)) 
                    continue;
                vis[nx][ny] = true;
                queue.offer(new int[] {nx, ny, w + 1});
            }
            
        }
        
        return -1;
    }
    
    private boolean isBoundary(int x, int y, int n, int m) {
        return (x == n - 1 || y == m - 1 || x == 0 || y == 0);
    }

    private boolean isValid(int x, int y, int n, int m, boolean[][] vis, char[][] maze) {
        return (x >= 0 && x < n && y >= 0 && y < m && !vis[x][y] && maze[x][y] == '.');
    }

}