class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
        int len = difficulty.length;
        
        Job[] jobs = new Job[len];
        for (int i = 0; i < len; ++i) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        
        Arrays.sort(jobs, (o1, o2) -> o1.difficulty - o2.difficulty);
        Arrays.sort(workers);
        
        int index = 0;
        int maxProfit = 0;
        int bestProfit = 0;
        
        for (int i = 0; i < workers.length; ++i) {
            int workerDifficulty = workers[i];
            
            while (index < len && jobs[index].difficulty <= workerDifficulty) {
                bestProfit = Math.max(bestProfit, jobs[index++].profit);
            }
            maxProfit += bestProfit;
        }
       return maxProfit;
    }
    class Job {
        int difficulty;
        int profit;
        
        Job (int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
}