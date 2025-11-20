class Solution {

    List<List<Integer>> res;
    int n, k;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        this.n = n;
        this.k = k;

        dfs(1, 1, new ArrayList<>());  
        return res;  
    }

    private void dfs(int i, int cur, List<Integer> list) {
        if (cur > k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j <= n; j++) {
            list.add(j);
            dfs(j + 1, cur + 1, list);
            list.removeLast();
        }

    }
}