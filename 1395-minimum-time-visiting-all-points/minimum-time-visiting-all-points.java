class Solution {
    public int minTimeToVisitAllPoints(int[][] pts) {
        int minTime = 0, cX, cY, tX, tY;

        for (int i = 0; i < pts.length - 1; ++i) {
            cX = pts[i][0]; cY = pts[i][1];
            tX = pts[i+1][0]; tY = pts[i+1][1];
            
            minTime += Math.max(Math.abs(tX - cX), Math.abs(tY - cY));
        }

        return minTime;
    }
}