class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int i = 0; i < nums.length; ++i) {
            int length = subsets.size();
            for (int j = 0; j < length; ++j) {
            List<Integer> currSubset = new ArrayList<>(subsets.get(j));
            currSubset.add(nums[i]);
            subsets.add(currSubset);
            }
        }
        return subsets;
    }
}