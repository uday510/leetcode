class Solution {
    
    private static final int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public boolean findSafeWalk(List<List<Integer>> grid, int h) {
        if (h - grid.getFirst().getFirst() < 1) 
            return false;

        int m = grid.size();
        int n = grid.getFirst().size();

        int[][] dist = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();

        dist[0][0] = h - grid.getFirst().getFirst();

        queue.offer(new int[] {0, 0, dist[0][0]});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], w = cur[2];

            if (x == m - 1 && y == n - 1) 
                return true;
            
            for (int[] nxt : DIRs) {
                int nx = nxt[0] + x;
                int ny = nxt[1] + y;
                
                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;

                int w1 = w - grid.get(nx).get(ny);

                if (w1 < 1 || w1 <= dist[nx][ny]) 
                    continue;

                dist[nx][ny] = w1;
                queue.offer(new int[] {nx, ny, w1});

            }
        }


        return false;
    }

}