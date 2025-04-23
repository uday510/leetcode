class Solution {
    List<List<Integer>> res;
    int[] nums;
    int n;
    public List<List<Integer>> fourSum(int[] nums, long target) {

        Arrays.sort(nums);
        res = new ArrayList<>();
        this.nums = nums;
        n = nums.length;

        return dfs(0, 4, target);
    }

    private List<List<Integer>> dfs(int idx, int k, long target) {

        if (k == 2) {
            return twoSum(idx, target);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = idx; i < (n - k + 1); ++i) {
            if (i > idx && nums[i] == nums[i - 1]) continue;

            List<List<Integer>> list = dfs(i + 1, k - 1, target - nums[i]);

            for (var subList : list) {
                var temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                temp.addAll(subList);
                result.add(temp);
            }
        }

        return result;
    }

    private List<List<Integer>> twoSum(int idx, long target) {
        List<List<Integer>> list = new ArrayList<>();
        int leftIdx = idx;
        int rightIdx = nums.length - 1;

        while (leftIdx < rightIdx) {
            long curr = (long) nums[leftIdx] + nums[rightIdx];

            if (curr < target) leftIdx++;
            else if (curr > target) rightIdx--;
            else {
                list.add(new ArrayList<>(Arrays.asList(nums[leftIdx], nums[rightIdx])));
                leftIdx++;
                rightIdx--;

                while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx - 1]) leftIdx++;
                while (leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx + 1]) rightIdx--;
            }
        }

        return list;
    }
}