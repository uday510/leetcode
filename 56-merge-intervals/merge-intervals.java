class Solution {
    public int[][] merge(int[][] ints) {
        

        List<int[]> res = new ArrayList<>();

        Arrays.sort(ints, (o1, o2) -> o1[0] - o2[0]);

        res.add(ints[0]);

        for (int[] cur : ints) {

            if (cur[0] <= res.getLast()[1]) {
                res.getLast()[1] = Math.max(cur[1], res.getLast()[1]);
            } else {
                res.add(cur);
            }

        }

        return res.toArray(new int[res.size()][]);

    }
}