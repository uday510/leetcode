class Solution {

    private static final char OPEN_BRACKET = '(';
    private static final char CLOSE_BRACKET = ')';
    private List<String> res;
    private StringBuilder sb;
    private int n;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        this.n = n;

        dfs(0, 0);

        return res;        
    }

    private void dfs(int l, int r) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (l < n) {
            sb.append(OPEN_BRACKET);
            dfs(l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            sb.append(CLOSE_BRACKET);
            dfs(l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}