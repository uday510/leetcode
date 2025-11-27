class Solution {

    Map<Integer, List<String>> dp;
    Set<String> dict;
    String s;
    int n;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.dp = new HashMap<>();
        this.dict = new HashSet<>(wordDict);
        this.s = s;
        this.n = s.length();

        return dfs(0);
    }

    private List<String> dfs(int i) {
        if (i >= n) return List.of("");

        if (dp.containsKey(i)) {
            System.out.println("CACHED");
            return dp.get(i);
        }

        List<String> res = new ArrayList<>();

        for (int j = i; j < n; j++) {
            String cur = s.substring(i, j + 1);
            if (!dict.contains(cur)) continue;

            for (String suffix : dfs(j + 1)) {
                if (suffix.isEmpty()) res.add(cur);
                else res.add(cur + " " + suffix);
            }
        }

        dp.put(i, res);

        return res;
    }
}