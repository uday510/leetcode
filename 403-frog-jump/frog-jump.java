class Solution {
    Map<String, Boolean> dp;
    Set<Integer> stones;
    public boolean canCross(int[] stones) {
        dp = new HashMap<>();
        this.stones = new HashSet<>();
        for (int stone : stones) this.stones.add(stone);

        return dfs(0, 0, stones[stones.length - 1]);
    }
    private boolean dfs(int curr, int k, int last) {
        if (curr == last) return true;

        String key = curr + "_" + k;
        if (dp.containsKey(key)) return dp.get(key);

        for (int nextK : new int[]{k - 1, k, k + 1}) {
            int jump = curr + nextK;
            if (nextK <= 0 || !stones.contains(jump)) continue;

            if (dfs(jump, nextK, last)) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }
}