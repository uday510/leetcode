class Solution {

    Map<Integer, List<String>> memo;
    Set<String> dict;
    String s;
    int n;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.n = s.length();
        this.dict = new HashSet<>(wordDict);
        this.memo = new HashMap<>();
        return dfs(0);
    }

    private List<String> dfs(int i) {
        if (memo.containsKey(i)) {
            System.out.println("CACHED");
            return memo.get(i);
        }
        
        if (i == n) return List.of("");

        List<String> result = new ArrayList<>();

        for (int j = i; j < n; j++) {
            String cur = s.substring(i, j + 1);
            if (!dict.contains(cur)) continue;

            for (String suffix : dfs(j + 1)) {
                if (suffix.isEmpty()) result.add(cur);
                else result.add(cur + " " + suffix);
            }
        }

        memo.put(i, result);
        return result;
    }
}