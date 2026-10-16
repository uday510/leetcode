class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(k -> k[0]));
        res.add(intervals[0]);
        
        for (int[] c : intervals) {

            if (c[0] <= res.getLast()[1]) {
                res.getLast()[1] = Math.max(c[1], res.getLast()[1]);
            } else {
                res.add(c);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}