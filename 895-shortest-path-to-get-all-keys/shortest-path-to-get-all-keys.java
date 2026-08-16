class Solution {

    private static final int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int shortestPathAllKeys(String[] grid) {
        
        int n = grid.length, m = grid[0].length();
        boolean[][][] vis = new boolean[n][m][64];
        Queue<int[]> queue = new ArrayDeque<>();

        int mask = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    queue.offer(new int[] {i, j, 0, 0});
                    vis[i][j][0] = true;
                }

                if (isKey(c)) {
                    mask |= (1 << (c - 'a'));
                }
            }
        }


        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], curMask = cur[2], w = cur[3];

            if (curMask == mask)
                return w;

            for (int[] dir : DIRs) {
                int nx = dir[0] + x, ny = dir[1] + y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                    
                char c = grid[nx].charAt(ny);

                if (isWall(c))
                    continue;
                
                if (isLock(c) && (curMask & (1 << (c - 'A'))) == 0)
                    continue;

                int newMask = isKey(c) ? (curMask | (1 << (c - 'a'))) : curMask;

                if (vis[nx][ny][newMask])
                    continue;

                vis[nx][ny][newMask] = true;
                queue.offer(new int[] {nx, ny, newMask, w + 1});
            } 
        }

        return -1;
    }

    private boolean isKey(char c) {
        return c >= 'a' && c <= 'z';
    }
    private boolean isLock(char c) {
        return c >= 'A' && c <= 'Z';
    }
    private boolean isWall(char c) {
        return c == '#';
    }
}