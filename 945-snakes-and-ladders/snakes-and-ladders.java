class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer, int[]> pos = new HashMap<>();
        Set<Integer> vis = new HashSet<>();
        generatePositions(pos, n);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0], w = curr[1];
            if (u == (n * n)) return w;

            if (vis.contains(u)) continue;
            vis.add(u);


            for (int v = u + 1; v <= Math.min (u + 6, (n * n)); ++v) {
                int[] coordinates = pos.get(v);
                int row = coordinates[0], col = coordinates[1];
                int next = v;

                if (board[row][col] != -1) {
                    next = board[row][col];
                }

                queue.offer(new int[] {next, w + 1});
            }
        }

        return -1;
    }

    private void generatePositions(Map<Integer, int[]> map, int n) {
        boolean movingRight = true;
        int currPos = 1;

        for (int i = n - 1; i > -1; --i) {

            if (movingRight) {
                for (int j = 0; j < n; ++j) {
                    map.put(currPos++, new int[] {i, j});
                }
            } else {
                for (int j = n - 1; j > -1; --j) {
                    map.put(currPos++, new int[] {i, j});
                }
            }
            movingRight = !movingRight;
        }
    }
}