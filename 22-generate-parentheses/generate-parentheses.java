class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void dfs(StringBuilder sb, int open, int close, int n) {
        if (sb.length() >= 2 * n) {
            ans.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            dfs(sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            dfs(sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}