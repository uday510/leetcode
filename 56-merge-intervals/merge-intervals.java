class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int len = intervals.length;
        var list = new ArrayList<int[]>();

        for (int idx = 0; idx < len;) {
            list.add(intervals[idx]);

            idx = findNextIndex(list.get(list.size() - 1), idx, intervals);
        }

        return list.toArray(new int[list.size()][]);
    }
    private int findNextIndex(int[] interval, int index, int[][] intervals) {

        while (index < intervals.length && interval[1] >= intervals[index][0]) {
            interval[1] = Math.max(interval[1], intervals[index][1]);

            index++;
        }

        return index;
    }
}


