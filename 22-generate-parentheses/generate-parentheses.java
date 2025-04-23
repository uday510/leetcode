class Solution {

    List<String> list;
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        list = new ArrayList<>();
        dfs(0, 0, new StringBuilder());
        return list;
    }

    private void dfs(int open, int close, StringBuilder curr) {
        if (curr.length() == 2 * n) {
            list.add(curr.toString());
            return;
        }

    if(close < open) {
            curr.append(")");
            dfs(open, close + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (open < n) {
            curr.append("(");
            dfs(open + 1, close, curr);
            curr.deleteCharAt(curr.length() - 1);
        }  
    }
}