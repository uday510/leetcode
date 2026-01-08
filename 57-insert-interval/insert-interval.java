class Solution {
    public int[][] insert(int[][] ints, int[] A) {
        int N = ints.length;
        int i = 0;
        List<int[]> res = new ArrayList<>();

        while (i < N && ints[i][1] < A[0]) {
            res.add(ints[i++]);
        } 

        while (i < N && A[1] >= ints[i][0]) {
            A[0] = Math.min(A[0], ints[i][0]);
            A[1] = Math.max(A[1], ints[i++][1]);
        }

        res.add(A);

        while (i < N) res.add(ints[i++]);

        return res.toArray(new int[res.size()][]);
    }
}

/**


[1, 2] [3, 4] [4, 6] [ 6, 7]

[4, 5]

 */