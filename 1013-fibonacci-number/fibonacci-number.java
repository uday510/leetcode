class Solution {

    public int fib(int n) {
        return dfs(n);
    }

    private int dfs(int n) {
        
       return n < 2 ? n : dfs(n - 1) + dfs(n - 2);
    }
}