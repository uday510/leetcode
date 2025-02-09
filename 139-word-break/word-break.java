class Solution {

    private int length;
    private Boolean[] memo;
    private Set<String> dictionary;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        initialize(s, wordDict);

        return dfs(0, s);
    }

    private boolean dfs(int index, String string) {
        if (index >= length) return true;

        if (memo[index] != null) return memo[index];

        for (int currentIndex = index; currentIndex < length; ++currentIndex) {
            String substring = string.substring(index, currentIndex + 1);

            if (dictionary.contains(substring) && dfs(currentIndex + 1, string)) {
                return memo[index] = true;
            }
        }

        return memo[index] = false;
    }

    private void initialize(String s, List<String> wordDict) {
        length = s.length();
        memo = new Boolean[length];
        dictionary = new HashSet<>(wordDict);
    }
}