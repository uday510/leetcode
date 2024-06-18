class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.difficulty - b.difficulty);

        Arrays.sort(worker);

        int maxProfit = 0;

        int j = 0;
        int best = 0;
        for (int i = 0; i < worker.length; i++) {
            while (j < n && jobs[j].difficulty <= worker[i]) {
                best = Math.max(best, jobs[j].profit);
                j++;
            }
            maxProfit += best;
        }
        return maxProfit;
    }
 class Job {
        int difficulty;
        int profit;
        Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
}