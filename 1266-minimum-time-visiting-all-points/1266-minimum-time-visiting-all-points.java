class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length - 1; ++i) {
            int currX = points[i][0];
            int currY = points[i][1];
            int targetX = points[i+1][0];
            int targetY = points[i+1][1];
            
            res += Math.max(Math.abs(targetX - currX), Math.abs(targetY - currY));
        }
        return res;
    }
}