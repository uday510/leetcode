class Solution {

    private List<List<Integer>> res;
    private int[] c;
    private int n, t;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        c = candidates;
        n = candidates.length;
        t = target;

        dfs(0, 0, new ArrayList<>());
        return res;    
    }

    private void dfs(int idx, int sum, List<Integer> curList) {
        if (sum == t) {
            res.add(new ArrayList<>(curList));
            return;
        }

        if (idx >= n || sum > t) return;

        for (int curIdx = idx; curIdx < n && (sum + c[curIdx]) <= t; curIdx++) {
            curList.add(c[curIdx]);
            dfs(curIdx, sum + c[curIdx], curList);
            curList.removeLast();
        }

    }
}