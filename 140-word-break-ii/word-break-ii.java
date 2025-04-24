class Solution {

    List<String> list;
    Set<String> words;
    String s;
    int n;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.n = s.length();
        this.words = new HashSet<>(wordDict);
        this.list = new ArrayList<>();

        dfs(0, new StringBuilder());

        return list;
    }

    private void dfs(int i, StringBuilder sb) {
        if (i == n) {
            list.add(sb.toString().trim());
            return;
        }

        for (int j = i + 1; j <= n; ++j) {
            String word = s.substring(i, j);
            if (!words.contains(word)) continue;

            int lenBefore = sb.length();
            sb.append(word).append(" ");

            dfs(j, sb);

            sb.setLength(lenBefore);
        }
    }
}
