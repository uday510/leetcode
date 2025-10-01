class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int cnt = 0;
        int[] p = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] c = intervals[i];
            if (p[1] > c[0]) {
                cnt++;
            } else {
                p = c;
            }
        }

        return cnt;
    }
}

// [[1,100], [1,11], [2,12], [11,22]]