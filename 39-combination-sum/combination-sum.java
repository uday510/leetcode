class Solution {
    List<List<Integer>> list;
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        dfs(0, 0, new ArrayDeque<>());
        return list;
    }
    private void dfs(int index, int currSum, Deque<Integer> queue) {
        if (currSum == target) {
            list.add(new ArrayList<>(queue));
            return;
        }

        for (int idx = index; idx < candidates.length; ++idx) {
            int candidate = candidates[idx];
            if (candidate + currSum > target) 
                continue;

            currSum += candidate;
            queue.offer(candidate);
            dfs(idx, currSum, queue);
            currSum -= candidate;
            queue.pollLast();
        }
    }
}