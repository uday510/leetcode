class Solution {
    private static int[][] directions = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
    
        int[][] res = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        
        Deque<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                
                if (mat[i][j] == 1) continue;
                
                queue.add(new int[] {i, j, 0});
                vis[i][j] = true;
            }
        }
        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            
            res[node[0]][node[1]] = node[2];
            
            
            for (int[] dir : directions) {
                
                int newX = dir[0] + node[0];
                int newY = dir[1] + node[1];
                int newDist = node[2] + 1;
                
                if (newX < 0 || newY < 0 || newX >= n || newY >= m || vis[newX][newY])
                    continue;
                
                vis[newX][newY] = true;
                queue.offer(new int[]{newX, newY, newDist});
            }
        }
        
        return res;
    }
}