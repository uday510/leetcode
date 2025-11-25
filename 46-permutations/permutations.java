class Solution {

    List<List<Integer>> perms;
    int[] nums;
    int n;

    public List<List<Integer>> permute(int[] nums) {
        perms = new ArrayList<>();
        this.nums = nums;
        this.n = nums.length;

        dfs(0);
        return perms;    
    }

    private void dfs(int i) {
        if (i >= n) {
            addPerm();
            return;
        }

        for (int j = i; j < n; j++) {
            swap(i, j);
            dfs(i + 1);
            swap(i, j);
        }
    }

    private void addPerm() {
        List<Integer> perm = new ArrayList<>();

        for (int num : nums) perm.add(num);

        perms.add(perm);
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}