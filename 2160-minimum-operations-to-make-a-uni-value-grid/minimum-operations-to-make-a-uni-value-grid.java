class Solution {
    public int minOperations(int[][] grid, int x) {
        
        List<Integer> list = new ArrayList<>();

        int mod = grid[0][0] % x;
        for (int[] row : grid) {
            for (int cur : row) {
                if (cur % x != mod) return -1;
                list.add(cur);
            }
        }

        Collections.sort(list);

        int m = list.get( list.size() >> 1);

        int ops = 0;

        for (int cur : list) {
            ops += Math.abs(cur - m) / x;
        }

        return ops;

    }
}
