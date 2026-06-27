class Solution {

    public List<List<Integer>> subsets(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();

        dfs(0, arr, new ArrayList<>(), res);

        return res;
    }

    private void dfs(int i, int[] arr, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));

        for (int j = i; j < arr.length; j++) {
            cur.add(arr[j]);
            dfs(j + 1, arr, cur, res);
            cur.removeLast();
        }
    }
}