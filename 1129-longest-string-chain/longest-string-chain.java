class Solution {

    private Map<String, Integer> dp;
    private Set<String> ws;
    private int n;

    public int longestStrChain(String[] words) {

        dp = new HashMap<>();
        ws = new HashSet<>();
        n = words.length;

        Collections.addAll(ws, words);

        int res = 1;
        for (String w : words) {
            res = Math.max(res, 1 + dfs(w));
        }

        return res;
    }

    private int dfs(String w) {
        if (dp.containsKey(w)) {
            return dp.get(w);
        }

        int cur = 0;
        for (int i = 0; i < w.length(); i++) {
            String sub = w.substring(0, i) + w.substring(i + 1);

            if (ws.contains(sub)) {
                cur = Math.max(cur, 1 + dfs(sub));
            }
        }

        dp.put(w, cur);
        return cur;
    }
}