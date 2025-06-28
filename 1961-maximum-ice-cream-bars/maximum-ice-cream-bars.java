class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int max = 0;
        int i = 0;

        while (i < costs.length && coins >= costs[i]) {
            int toBeTaken = Math.min(coins, costs[i++]);
            coins -= toBeTaken;
            max++;
        }
        return max;
    }
}