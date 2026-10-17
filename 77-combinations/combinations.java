class Solution {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        dfs(1, n, k, new ArrayList<>(), res);
        return res;        
    }

    private void dfs(int i, int n, int k, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }


        for (int j = i; j <= n && j <= (n - (k - cur.size()) + 1); j++) {
            cur.add(j);
            dfs(j + 1, n, k, cur, res);
            cur.removeLast();
        }
    }
}