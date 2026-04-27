class Solution {

    private static Map<Integer, int[][]> DIRs = new HashMap<>();

    static {

        DIRs.put(1, new int[][] {{0, -1}, {0, 1}});
        DIRs.put(2, new int[][] {{-1, 0}, {1, 0}});
        DIRs.put(3, new int[][] {{0, -1}, {1, 0}});
        DIRs.put(4, new int[][] {{0, 1}, {1, 0}});
        DIRs.put(5, new int[][] {{0, -1}, {-1, 0}});
        DIRs.put(6, new int[][] {{0, 1}, {-1, 0}});

    }

    public boolean hasValidPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            if (dx == n - 1 && dy == m - 1) {
                return true;
            }

            for (int[] dir : DIRs.get(grid[dx][dy])) {
                int nx = dir[0] + dx;
                int ny = dir[1] + dy;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny]) continue;

                boolean isValid = false;

                for (int[] backDir : DIRs.get(grid[nx][ny])) {

                    if (nx + backDir[0] == dx && ny + backDir[1] == dy) {

                        isValid = true;

                        break;

                    }

                }

                if (!isValid) continue;
                            
                vis[nx][ny] = true;
                            
                queue.offer(new int[] {nx, ny});
                                    
                }


            }


        return false;
    }
}
