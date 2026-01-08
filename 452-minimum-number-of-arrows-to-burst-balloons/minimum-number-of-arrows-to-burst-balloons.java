class Solution {
    public int findMinArrowShots(int[][] points) {
        

        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int[] cur = points[0];
        int arrows = 1;

        for (int[] p : points) {
            int s1 = cur[0], s2 = p[0];
            int e1 = cur[1], e2 = p[1];

            if (e1 < s2) {
                arrows++;
                cur = p;
            } else {
                cur[1] = Math.min(cur[1], e2);
            }
        }

        return arrows;
    }
}