class Solution {

    private Map<String, Boolean> dp;
    Set<Integer> stones;
    private int lastStone;


    public boolean canCross(int[] arr) {
        lastStone = arr[arr.length - 1];
        dp = new HashMap<>();
        stones = new HashSet<>();

        for (int s : arr) stones.add(s);

        return dfs(0, 0);
    }

    private boolean dfs(int idx, int k) {
        if (idx > lastStone) return false;
        if (idx == lastStone) return true;
        String key = idx + ":" + k;

        if (dp.containsKey(key)) return dp.get(key);

        for (int nxt : new int[] {k - 1, k, k + 1}) {
            int jmp = idx + nxt;
            if (nxt <= 0 || !stones.contains(jmp)) continue;

            boolean cur = dfs(jmp,  nxt);

            if (cur) {
                dp.put(key, true);
                return true;
            }
        }
        
        dp.put(key, false);
        return false;
    }
}