class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int N = intervals.length;
        int i = 0;
        var res = new ArrayList<int[]>();

        while (i < N && intervals[i][1] < newInterval[0]) 
            res.add(intervals[i++]);

        while (i < N && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }
        res.add(newInterval);

        while (i < N) 
            res.add(intervals[i++]);

        return res.toArray(new int[res.size()][]);
    }
}