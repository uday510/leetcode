class Solution {

    List<List<Integer>> combs;
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        this.candidates = candidates;
        this.target = target;
        combs = new ArrayList<>();

        dfs(0, 0, new ArrayList<>());
        return combs;
    }
    private void dfs(int i, int sum, ArrayList<Integer> list) {
        if (i >= candidates.length || sum > target) return;

        if (sum == target) {
            combs.add(new ArrayList<>(list));
            return;
        }

        list.add(candidates[i]);
        sum += candidates[i];
        dfs(i, sum, list);
        list.remove(list.size() - 1);
        sum -= candidates[i];
        dfs(i + 1, sum, list);
    }
}