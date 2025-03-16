class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        dfs(0, 0, n, new StringBuilder());
        return list;
    }
    private void dfs(int open, int close, int n, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            list.add(sb.toString());
            return;
        }

        if (open < n) {
            dfs(open + 1, close, n, sb.append("("));
            sb.deleteCharAt(sb.length() - 1);
        }
            
        
        if (close < open) {
            dfs(open, close + 1, n, sb.append(")"));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}