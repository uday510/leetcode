class Solution {

    private char[][] grid;
    private int n, m;
    private final int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private boolean[][] vis;
    
    public int numIslands(char[][] grid) {
        initialize(grid);
        
        int islands = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] || grid[i][j] == '0') continue;
                
                islands++;
                bfs(i, j);
            }
        }
        
        
        return islands;
    }
    
    private void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        vis[i][j] = true;
        queue.offer(new int[] {i, j});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];
            
            for (int[] dir : dirs) {
                int nx = dx + dir[0], ny = dy + dir[1];
                
                if (!valid(nx, ny)) continue;
                
                vis[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
    }
    
    private boolean valid(int nx, int ny) {
        return (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny] && grid[nx][ny] == '1');
    }
    
    private void initialize(char[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
    } 
}