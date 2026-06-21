class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int mx = 0, i = 0;

        while (i < costs.length && coins >= costs[i]) {
            coins -= costs[i++];

            mx++;
        }
        
        return mx;
    }
}
