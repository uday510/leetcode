class Solution {

    Map<String, Integer> dp;
    Set<String> w;

    public int longestStrChain(String[] words) {
        dp = new HashMap<>();
        w = new HashSet<>();

        for (String word : words) w.add(word);

        int cur = 0;
        for (String w : words) {
            cur = Math.max(cur, dfs(w));
        }

        return cur;    
    }

    private int dfs(String s) {
        if (dp.containsKey(s)) return dp.get(s);

        int cur = 1;

        for (int i = 0; i < s.length(); i++) {
            String st = s.substring(0, i) + s.substring(i + 1);

            if (w.contains(st)) {
                cur = Math.max(cur, 1 + dfs(st));
            }
        }

        dp.put(s, cur);

        return cur;
    }
}