class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int[] curr = points[0];
        int arrows = 1;
        for (int[] p : points) {
            int S2 = p[0];
            int E2 = p[1];
            int S1 = curr[0];
            int E1 = curr[1];

            if (E1 < S2) {
                ++arrows;
                curr = p;
            } else {
                curr[1] = Math.min(curr[1], p[1]);
            }
        }
        return arrows;
    }
}