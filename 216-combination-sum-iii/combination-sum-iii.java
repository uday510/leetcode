class Solution {
    List<List<Integer>> res;
    List<Integer> list;
    int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        this.k = k;

        dfs(0, n);
        return res;
    }

    private void dfs (int i, int remain) {
        if (remain == 0 && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        } else if (remain < 0 || list.size() == k) {
            return;
        }

        for (int j = i; j < 9; ++j) {
            list.add(j + 1);
            dfs(j + 1, remain - j - 1);
            list.removeLast();
        }
    }
}
