class Solution {

    List<List<Integer>> res;
    int n, k;

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();
        this.n = n;
        this.k = k;

        dfs(0, new ArrayList<>());  
        return res;  
    }

    private void dfs(int i, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = i + 1; j <= n; j++) {
            list.add(j);
            dfs(j, list);
            list.removeLast();
        }
        
    }
}