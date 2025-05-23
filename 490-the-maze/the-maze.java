class Solution {
    
    boolean[][] vis;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        vis = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination);
    }
    
    final private int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    private boolean dfs(int[][] maze, int[] curr, int[] dest) {
        int r = curr[0], c = curr[1];
        
        if (r == dest[0] && c == dest[1]) return true;
        
        if (vis[r][c]) return false;

        vis[r][c] = true;

        for (int[] dir : dirs) {
            int R = dir[0] + r;
            int C = dir[1] + c;
            
            while (R >= 0 && R < maze.length &&
                    C >= 0 && C < maze[0].length && 
                    maze[R][C] == 0
            ) {
                R += dir[0];
                C += dir[1];
            }
            
            R -= dir[0];
            C -= dir[1];
            
            if (dfs(maze, new int[]{R, C} , dest)) {
                return true;
            }
        }
        
        return false;
    }
}
