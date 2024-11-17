class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();

        dfs(0, 0, new StringBuilder(), n);

        return ans;
    }
    private void dfs(int open, int close, StringBuilder sb, int n) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            System.out.println(sb + " " + ans);
            return;
        }

       if (open < n) {
            add(sb, "(");
            dfs(open + 1, close, sb, n);
            remove(sb);
       }

       if (close < open) {
        add(sb, ")");
        dfs(open, close + 1, sb, n);
        remove(sb);
       }
    }

    private void add(StringBuilder sb, String s) {
        sb.append(s);
    }

    private void remove(StringBuilder sb) {
        sb.deleteCharAt(sb.length() - 1);
    }
}