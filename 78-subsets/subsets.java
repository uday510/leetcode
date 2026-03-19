class Solution {

    private List<List<Integer>> res;
    private int[] arr;
    private int n;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        arr = nums;
        n = nums.length;

        dfs(0, new ArrayList<>());
        return res;    
    }

    private void dfs(int idx, List<Integer> curList) {  
        res.add(new ArrayList<>(curList));

        for (int curIdx = idx; curIdx < n; curIdx++) {
            curList.add(arr[curIdx]);
            dfs(curIdx + 1, curList);
            curList.removeLast();
        }

    }
}