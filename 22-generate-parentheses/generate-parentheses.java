class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        dfs(0, 0, n, "");
        return list;
    }
    private void dfs(int open, int close, int n, String str) {
        if (str.length() == 2 * n) {
            list.add(str);
            return;
        }

        if (open < n) 
            dfs(open + 1, close, n, str + "(");
        if (open > close)
            dfs(open, close + 1, n, str + ")");
    }
}