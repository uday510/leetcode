class Solution {

    private final static String OPEN = "(";
    private final static String CLOSE = ")";
    List<String> res;
    int n;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        this.n = n;

        dfs(0, 0, new StringBuilder());
        return res;    
    }

    private void dfs(int l, int r, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (l < n) {
            sb.append(OPEN);
            dfs(l + 1, r, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            sb.append(CLOSE);
            dfs(l, r + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}