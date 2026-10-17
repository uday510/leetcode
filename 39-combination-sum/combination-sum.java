class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int t) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);
        dfs(0, 0, t, arr.length, arr, new ArrayList<>(), res);
        return res;
    }
    private void dfs(int i, int sm, int t, int n, int[] arr, List<Integer> cur, List<List<Integer>> res) {
        if (sm == t) {
            res.add(new ArrayList<>(cur));
            return;
        }

        
        for (int j = i; j < n; j++) {
            if (sm + arr[j] > t) break;
            cur.add(arr[j]);
            dfs(j, sm + arr[j], t, n, arr, cur, res);
            cur.removeLast();
        }
    }
}