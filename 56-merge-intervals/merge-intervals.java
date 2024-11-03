class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int N = intervals.length;
        var list = new ArrayList<int[]>(); 

        for (int i = 0; i < N;) {
            list.add(intervals[i]);

            i = findNext(list, intervals, i+1, N);
        }

        return list.toArray(new int[list.size()][]);
    }
    int findNext(ArrayList<int[]> list, int[][] intervals, int idx, int N) {

        while (idx < N && list.get(list.size()-1)[1] >= intervals[idx][0]) {
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], 
                                                        intervals[idx][1]);
                ++idx;
        }
        return idx;
    }
}