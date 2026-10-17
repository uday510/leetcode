class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        dfs(0, 0, n, new StringBuilder(), res);
        return res;
    }

    private void dfs(int l, int r, int n, StringBuilder sb, List<String> res) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (l < n) {
            sb.append("(");
            dfs(l + 1, r, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            sb.append(")");
            dfs(l, r + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}