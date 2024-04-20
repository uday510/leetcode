import java.util.ArrayList;
import java.util.List;

class Solution {
    private int rowSize;
    private int colSize;
    private static final int FOREST_LAND = 0;
    private static final int FARM_LAND = 1;
    
    public int[][] findFarmland(int[][] land) {
        rowSize = land.length;
        colSize = land[0].length;
        List<int[]> res = new ArrayList<>();
        
        boolean[][] visited = new boolean[rowSize][colSize];

        for (int currRow = 0; currRow < rowSize; ++currRow) {
            for (int currCol = 0; currCol < colSize; ++currCol) {
                if (land[currRow][currCol] == FARM_LAND && !visited[currRow][currCol]) {
                    int[] bottomRight = dfs(currRow, currCol, land, visited);
                    res.add(new int[]{currRow, currCol, bottomRight[0], bottomRight[1]});
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    private int[] dfs(int rowIdx, int colIdx, int[][] land, boolean[][] visited) {
        if (rowIdx < 0 || rowIdx >= rowSize || colIdx < 0 || colIdx >= colSize ||
            land[rowIdx][colIdx] == FOREST_LAND || visited[rowIdx][colIdx]) {
            return new int[]{rowIdx - 1, colIdx - 1};
        }

        visited[rowIdx][colIdx] = true;
        int[] right = dfs(rowIdx, colIdx + 1, land, visited);
        int[] down = dfs(rowIdx + 1, colIdx, land, visited);
        return new int[]{Math.max(rowIdx, down[0]), Math.max(colIdx, right[1])};
    }
}
