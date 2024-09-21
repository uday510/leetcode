class Solution {
    List<Integer> list;
    public List<Integer> lexicalOrder(int n) {
        list = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) 
            dfs(i, n);
        
        return list;
    }
    private void dfs(int curr, int n) {
        if (curr > n) 
            return;
        
        list.add(curr);

        for (int idx = 0; idx <= 9; ++idx) {
            int val = curr * 10 + idx;

            if (val > n) 
                return;
            
            dfs(val, n);
        }
    }
}