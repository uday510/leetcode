class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        
        long maxHappiness = 0L;
        
        int delay = 0;
        int index = happiness.length - 1;
        while (k-- > 0) {
            maxHappiness += Math.max(happiness[index--] - delay++, 0)*1L;
        }
        
        return maxHappiness;
    }
}

    