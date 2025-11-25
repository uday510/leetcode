class Solution {

    List<List<Integer>> res;
    int[] c;
    int t, n;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        c = candidates;
        t = target;
        n = c.length;

        dfs(0, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int i, List<Integer> list, int cur) {
        if (cur == t) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (cur > t || i >= n) {
            return;
        }

        dfs(i + 1, list, cur);

        list.add(c[i]);
        dfs(i, list, cur + c[i]);
        list.removeLast();
    }
}