class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int N = profits.length;
        List<IPO> ipos = new ArrayList<>();

        for (int index = 0; index < N; ++index) {
            ipos.add(new IPO(profits[index], capital[index]));
        }

        Collections.sort(ipos, (o1, o2) -> Integer.compare(o1.capital, o2.capital));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        int i = 0;
        for (int index = 0; index < k; ++index) {

            while (i < N && ipos.get(i).capital <= w) {
                priorityQueue.offer(ipos.get(i).profit);
                i++;
            }

            if (priorityQueue.isEmpty()) {
                break;
            }

            w += priorityQueue.poll();
        }

        return w;
    }
    private class IPO {
        int profit;
        int capital;

        IPO(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}