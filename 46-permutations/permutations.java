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
            swap(i, j, cur);
            dfs(i + 1, n, cur, res);
            swap(i, j, cur);
        }
    }

    private void swap(int i, int j, List<Integer> list) {
        Integer tmp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, tmp);
    }
}