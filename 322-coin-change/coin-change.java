class Solution {
    public int coinChange(int[] coins, int amount) {
        Queue<Integer> queue = new LinkedList<>();
        int currentCoins = 0;
        Set<Integer> seen = new HashSet<>();

        queue.offer(0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int currentAmount = queue.poll();

                if (currentAmount == amount) {
                    return currentCoins;
                }

                if (seen.contains(currentAmount)) {
                    continue;
                }

                seen.add(currentAmount);

                for (int coin : coins) {
                    if (currentAmount + coin <= amount) {
                        queue.offer(currentAmount + coin);
                    }
                }
            }

            ++currentCoins;
        }

        return -1;
    }
}