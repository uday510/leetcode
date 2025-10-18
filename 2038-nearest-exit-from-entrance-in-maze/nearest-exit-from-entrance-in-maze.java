class Solution {
   
    private static final int[][] dirs = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };
    int n, m;
    char[][] maze;
    
    public int nearestExit(char[][] maze, int[] entrance) {
        n = maze.length;
        m = maze[0].length;
        this.maze = maze;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][m];
        queue.offer(new int[] {entrance[0], entrance[1], 0});
        vis[entrance[0]][entrance[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1], d = cur[2];
            
            for (int[] dir : dirs) {
                int nx = dir[0] + dx, ny = dir[1] + dy;
                
                if (isValid(nx, ny) && !vis[nx][ny] && maze[nx][ny] == '.') {
                    if (isExit(nx, ny)) return d + 1;
                    queue.offer(new int[] {nx, ny, d + 1});
                    vis[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
    
    private boolean isExit(int x, int y) {
        return isValid(x, y) && isBoundary(x, y);
    }
    
    private boolean isValid(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
    
    private boolean isBoundary(int x, int y) {
      if (x == 0 || x == n - 1) {
          return true;
      }
      
      return y == 0 || y == m - 1;
    }
}