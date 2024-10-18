class Solution {
    public int countMaxOrSubsets(int[] nums) {
        var subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<>());
        int maxOR = 0;

        for (int num : nums) {
            int len = subsets.size();
            int curr = 0;
            for (int idx = 0; idx < len; ++idx) {
                List<Integer> tmp = new ArrayList<>(subsets.get(idx));
                tmp.add(num);
                for (Integer val : tmp) {
                    curr |= val;
                }
                maxOR = Math.max(maxOR, curr);
                subsets.add(tmp);
            }
        }
        int cnt = 0;
        for (var list : subsets) {

            int curr = 0;
            for (var val : list) {
                curr |= val;
            }
            if (curr == maxOR) {
                ++cnt;
            }
            curr = 0;
        }
        return cnt;
    }
}