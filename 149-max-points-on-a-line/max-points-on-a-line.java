class Solution {
    public int maxPoints(int[][] points) {
        int N = points.length;
        int max = 1;

        for (int i = 0; i < N; ++i) {
            int[] p1 = points[i];

            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < N; ++j) {
                if (i == j) continue;
                
                int[] p2 = points[j];
                double slope;

                if (p1[0] - p2[0] == 0) {
                    slope = Integer.MAX_VALUE;
                } else {
                    slope = (p2[1] - p1[1]) * 1.0 / (p2[0] - p1[0]);
                }

                map.put(slope, map.getOrDefault(slope, 1) + 1);

                max = Math.max(max, map.get(slope));
            }
        }

        return max;
    }
}