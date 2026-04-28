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

/**

[2, 4, 6, 8], x = 2
0, 2, 3, 4 -> 8
1, 0, 1, 2 -> 4
3, 1, 0, 1 -> 5
4, 2, 1, 0 -> 7

[1, 2, 3, 5], x = 1
0, 1, 2, 4 -> 7
1, 0, 1, 3 -> 5
2, 1, 0, 2 -> 4
4, 3, 2, 0 -> 9

[1, 2, 3, 4], x = 2
0, -> -1

*/