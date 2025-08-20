class Solution {
    public int deleteAndEarn(int[] nums) {
        
        Map<Integer, Integer> points = new HashMap<>();
        int max = 0;

        for (int num : nums) {
            max = Math.max(num, max);
            points.merge(num, num, Integer::sum);
        }

        int p0 = 0;
        int p1 = points.getOrDefault(1, 0);

        for (int i = 2; i <= max; ++i) {
            int p2 = Math.max(p1, p0 + points.getOrDefault(i, 0));

            p0 = p1;
            p1 = p2;
        }

        return p1;
    }
}