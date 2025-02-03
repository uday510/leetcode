class Solution {
    public int fib(int n) {
        return dfs(n);
    }

    private int dfs(int n) { // 1
       if (n < 1) {
            return 0;
       }
       
       if (n == 1) {
            return 1;
       }
       
       return dfs(n - 1) + dfs(n - 2);
    }
}