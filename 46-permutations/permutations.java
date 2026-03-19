class Solution {

    private List<List<Integer>> res;
    private List<Integer> arr;
    private int n;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        arr = new ArrayList<>();
        for (int num : nums) arr.add(num);
        n = arr.size();

        dfs(0);
        return res;    
    }

    private void dfs(int idx) {
        if (idx == n) {
            res.add(new ArrayList<>(arr));
            return;
        }

        for (int curIdx = idx; curIdx < n; curIdx++) {
            swap(curIdx, idx);
            dfs(idx + 1);
            swap(curIdx, idx);
        }
    }

    private void swap(int i, int j) {
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }
}