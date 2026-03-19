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

    private void dfs(int i, List<Integer> cur) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j <= n; j++) {
            cur.add(j);
            dfs(j + 1, cur);
            cur.removeLast();
        }

    }
}