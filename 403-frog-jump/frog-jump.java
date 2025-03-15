class Solution {
    Map<String, Boolean> dp;
    Set<Integer> stones;
    public boolean canCross(int[] stones) {
        dp = new HashMap<>();
        this.stones = new HashSet<>();
        for (int stone : stones) this.stones.add(stone);

        return dfs(0, 0, stones[stones.length - 1]);
    }

    private boolean dfs(int currPos, int k, int lastStone) {
        if (currPos == lastStone) return true;

        String key = currPos + "_" + k;
        if (dp.containsKey(key)) return dp.get(key);

        for (int nextK : new int[]{k - 1, k, k + 1}) {
            int nextJump = currPos + nextK;
            if (!stones.contains(nextJump) || nextK <= 0) continue;

            if (dfs(nextJump, nextK, lastStone)) {
                dp.put(key, true);
                return true;
            }
        }


        dp.put(key, false);
        return false;
    }
}