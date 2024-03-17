class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);
        
        for (int[] nextInterval : intervals) {
            
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];
            
            if (currentIntervalEnd >= nextIntervalStart) {
                currentInterval[1] = Math.max(currentInterval[1], nextIntervalEnd);
                currentIntervalEnd = nextIntervalStart;
            } else {
                currentInterval = nextInterval;
                mergedIntervals.add(currentInterval);
            }
        }
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}