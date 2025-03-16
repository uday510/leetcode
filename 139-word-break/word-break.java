class Solution {
    Set<String> words;
    Map<Integer, Boolean> dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        words = new HashSet<>(wordDict);
        dp = new HashMap<>();
        return dfs(0, s);
    }
    private boolean dfs(int index, String s) {
        if (index >= s.length()) return true;

        if (dp.containsKey(index)) return dp.get(index);

        for (int i = index; i < s.length(); ++i) {
            String substr = s.substring(index, i+1);
            if (words.contains(substr)) {
                if (dfs(i + 1, s)) {
                    dp.put(index, true);
                    return true;
                }
            }
        }

        dp.put(index, false);
        return false;
    }
}