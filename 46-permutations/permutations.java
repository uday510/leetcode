class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int a : arr) cur.add(a);

        dfs(0, arr.length, cur, res);
        return res;
    }
    private void dfs(int i, int n, List<Integer> cur, List<List<Integer>> res) {
        if (i == n) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < n; j++) {
            Collections.swap(cur, i, j);
            dfs(i + 1, n, cur, res);
            Collections.swap(cur, i, j);
        }
    }
}