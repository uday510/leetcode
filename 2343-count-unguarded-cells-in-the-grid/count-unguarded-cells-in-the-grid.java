class Solution {
    
    Set<String> wall;
    Set<String> guard;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int visited = 0;
        boolean[][] vis = new boolean[m][n];
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        wall = new HashSet<>();
        guard = new HashSet<>();

        for (int[] g : guards) {
            int x = g[0], y = g[1];
            vis[x][y] = true;
            visited++;
            guard.add(x + ":" + y);
        }

        for (int[] w : walls) {
            int x = w[0], y = w[1];
            vis[x][y] = true;
            visited++;
            wall.add(x + ":" + y);
        }

        for (int[] g : guards) {
            int x = g[0], y = g[1];

            for (int[] dir : dirs) {
                int nx = dir[0] + x, ny = dir[1] + y;

                while (nx >= 0 && nx < m && ny >= 0 && ny < n && !isGuardOrWall(nx, ny)) {
                    if (!vis[nx][ny]) {
                        vis[nx][ny] = true;
                        visited++;
                    }
                    
                    nx += dir[0];
                    ny += dir[1];
                }
            }
        }

        return (m * n) - visited;
    }

    private boolean isGuardOrWall(int x, int y) {
        String k = x + ":" + y;
        
        return guard.contains(k) || wall.contains(k);
    }
}
