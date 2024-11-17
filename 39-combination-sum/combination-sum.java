class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();

        dfs(0, 0, candidates.length, new ArrayDeque(), candidates, target);

        return ans;
    }
    private void dfs(int index, int sum, int n, Deque<Integer> queue, int[] candidates, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(queue));
            return;
        }

        for (int i = index; i < n; ++i) {
            
            if (sum + candidates[i] > target) {
                continue;
            }

            sum += candidates[i];
            queue.offer(candidates[i]);
            dfs(i, sum, n, queue, candidates, target);

            sum -= candidates[i];
            queue.pollLast();
        }
    }
}