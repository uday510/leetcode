class Solution {
    
    private List<List<Integer>> res;
    private int n, k;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        this.n = n;
        this.k = k;

        dfs(1, new ArrayList<>());
        return res;
    }
    
    private void dfs(int idx, List<Integer> curList) {
        if (curList.size() == k) {
            res.add(new ArrayList<>(curList));
            return;
        }

        for (int curIdx = idx; curIdx <= n - (k - curList.size() - 1); curIdx++) {
            curList.add(curIdx);
            dfs(curIdx + 1, curList);
            curList.removeLast();
        }
    }
}