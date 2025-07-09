class Solution {

    int[] candidates;
    int target;
    List<List<Integer>> combs;
    int n;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        combs = new ArrayList<>();
        this.n = candidates.length;

        dfs(0, 0, new ArrayList<>());

        return combs;
    }

    private void dfs (int i, int sum, List<Integer> list) {
        if (sum == target) {
            combs.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < n; ++j) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;

            if (sum + candidates[j] > target) break;

            list.add(candidates[j]);
            dfs(j + 1, sum + candidates[j], list);
            list.removeLast();
        }
    }
}