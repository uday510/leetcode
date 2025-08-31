class Solution {
    public boolean checkStraightLine(int[][] C) {
        int x1 = C[0][0], y1 = C[0][1], x2 = C[1][0], y2 = C[1][1];

        for (int i = 2; i < C.length; i++) {
            int x3 = C[i][0], y3 = C[i][1];

            if ((y3 - y2) * (x3 - x1) != (y3 - y1) * (x3 - x2)) return false;
        }

        return true;
    }
}