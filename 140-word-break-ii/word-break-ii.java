class Solution {

    List<String> res;
    Set<String> words;
    String s;
    int n;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.n = s.length();
        this.words = new HashSet<>(wordDict);
        this.res = new ArrayList<>();

        dfs(0, new StringBuilder());

        return res;    
    }

    private void dfs(int i, StringBuilder sb) {
        if (i >= n) {
            res.add(sb.toString().trim());
            return;
        }

        for (int j = i; j < n; j++) {
            String cur = s.substring(i, j + 1);
            if (!words.contains(cur)) continue;

            int before = sb.length();
            sb.append(cur).append(" ");

            dfs(j + 1, sb);

            sb.setLength(before);
        }
    }
}