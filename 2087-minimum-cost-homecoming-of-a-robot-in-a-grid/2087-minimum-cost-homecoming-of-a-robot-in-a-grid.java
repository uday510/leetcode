class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int sRow = startPos[0];
        int sCol = startPos[1];
        int dRow = homePos[0];
        int dCol = homePos[1];
        int minCost = 0;

        while (sRow != dRow) {
            sRow += sRow < dRow ? 1 : -1;
            minCost += rowCosts[sRow];
        }

        while (sCol != dCol) {
            sCol += sCol < dCol ? 1 : -1;
            minCost += colCosts[sCol];
        }
        return minCost;
    }
}