class Solution {
    public int minOperations(int[][] grid, int x) {
        
        List<Integer> list = new ArrayList<>();

        for (int[] row : grid) {
            for (int cur : row) {
                list.add(cur);
            }
        }

        Collections.sort(list);

        int sweetSpot = list.get( list.size() >> 1);

        int ops = 0;

        for (int cur : list) {

            if (cur % x != sweetSpot % x) {
                return -1;
            }

            ops += Math.abs(cur - sweetSpot) / x;
        }

        return ops;

    }
}
