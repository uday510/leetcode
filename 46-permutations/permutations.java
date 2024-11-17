class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();

        dfs(0, nums.length, nums);
        
        return ans;
    }
    private void dfs(int index, int n, int[] nums) {
        if (index >= n) {
            add(nums);
            return;
        }
        
        for (int i = index; i < n; ++i) {

            swap(index, i, nums);
            dfs(index + 1, n, nums);
            swap(index, i, nums);
        }
    }
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    private void add(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        ans.add(new ArrayList<>(list));
    }
}