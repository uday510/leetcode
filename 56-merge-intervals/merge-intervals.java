class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        for (int[] i : intervals) {

            if (res.isEmpty() || res.getLast()[1] < i[0]) {
                res.add(i);
            } else {
                res.getLast()[1] = Math.max(i[1], res.getLast()[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}