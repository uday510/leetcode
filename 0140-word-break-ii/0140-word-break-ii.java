class Solution {
    Set<String> words;
    List<String> sentences;
    public List<String> wordBreak(String s, List<String> wordDict) {
        words = new HashSet<>(wordDict);
        sentences = new ArrayList<>();
        dfs(0, "", s);
        return sentences;
    }
    public void dfs(int i, String curr, String s) {
        if (i == s.length()) {
            sentences.add(curr);
            return;
        }

        for (int j = i; j < s.length(); ++j) {
            String substr = s.substring(i, j+1);
            if (words.contains(substr)) {
                if (curr.length() == 0) {
                    dfs(j+1, substr, s);
                } else {
                    dfs(j+1, curr+ " " + substr, s);
                }
            }
        }
    }
}