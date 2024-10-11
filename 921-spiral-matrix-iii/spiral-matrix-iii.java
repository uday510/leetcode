class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<int[]> result = new ArrayList<>();

        result.add(new int[]{rStart, cStart});

        if (rows * cols == 1) {
            return result.toArray(new int[1][2]);
        }
        int step = 1;
        int dirIdx = 0;

        while (result.size() < rows * cols) {

            for (int i = 0; i < 2; ++i) {
                for (int s = 0; s < step; ++s) {

                    rStart += directions[dirIdx][0];
                    cStart += directions[dirIdx][1];

                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result.add(new int[]{rStart, cStart});
                    }
                }
                dirIdx = (dirIdx + 1) % 4;
            }
            ++step;
        }
        return result.toArray(new int[rows][cols]);
    }
}