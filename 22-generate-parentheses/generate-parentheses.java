class Solution {
    int n;
    List<String> list;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.list = new ArrayList<>();

        dfs(0, 0, new StringBuilder());
        return list;
    }

    private void dfs(int left, int right, StringBuilder sb) {
        if (sb.length() >= 2 * n) {
            list.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            dfs(left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(")");
            dfs(left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}