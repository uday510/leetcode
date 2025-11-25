class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int mx = 1;

        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];

            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int[] p2 = points[j];
                double slope;

                if (p1[0] - p2[0] == 0) {
                    slope = Integer.MAX_VALUE;
                } else {
                    slope = (p2[1] - p1[1]) * 1.0 / (p2[0] - p1[0]);
                }

                map.put(slope, map.getOrDefault(slope, 1) + 1);

                mx = Math.max(mx, map.get(slope));
            }
        }

        return mx;
    }
}