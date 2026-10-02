class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();

        dfs(0, 0, n, new StringBuilder());
        return res;
    }

    private void dfs(int l, int r, int n, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (l < n) {
            sb.append("(");
            dfs(l + 1, r, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        } 
        if (r < l) {
            sb.append(")");
            dfs(l, r + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}