class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();

        dfs(0, 0, candidates.length, new ArrayList(), candidates, target);

        return ans;
    }
    private void dfs(int index, int sum, int n, List<Integer> list, int[] candidates, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (index >= n) {
            return;
        }

        for (int i = index; i < n; ++i) {
            
            if (sum + candidates[i] > target) {
                 continue;
            }

            sum += candidates[i];
            list.add(candidates[i]);
            dfs(i, sum, n, list, candidates, target);

            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}