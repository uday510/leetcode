class Solution {
    public int subsetXORSum(int[] nums) {
        int XORSum = 0;
        var subsets = getSubsets(nums);

        for (var subset : subsets) {
            int xor = 0;
            for (int num : subset) 
                xor ^= num;

            XORSum += xor;
        }

        return XORSum;
    }

    private List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : nums) {
            int len = subsets.size();
            for (int idx = 0; idx < len; ++idx) {
                List<Integer> subset = new ArrayList<>(subsets.get(idx));
                subset.add(num);
                subsets.add(subset);
            }
        }
        return subsets;
    }
}