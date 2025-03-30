class Solution {
    private final int[][] dirs = {{0, 1},{1, 0}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int freshOranges = 0;
        int minutes = -1;
        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {
                int curr = grid[row][col];
                if (curr == 0) continue;
                if (curr == 1) freshOranges++;
                else queue.offer(new int[]{row, col});
            }
        }
        
        if (freshOranges == 0) return 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int idx = 0; idx < size; ++idx) {

                int[] curr = queue.poll();

                for (int[] dir : dirs) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];

                    if (x < 0 || x >= numRows || y < 0 || y >= numCols || grid[x][y] != 1) continue;

                    queue.offer(new int[]{x, y});
                    grid[x][y] = 2;
                    freshOranges--;
                }
            }

            ++minutes;
        }

        return freshOranges == 0 ? minutes : -1;
    }
}