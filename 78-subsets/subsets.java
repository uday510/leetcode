class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            int len = res.size();
            for(int idx = 0; idx < len; ++idx) {
                List<Integer> tmp = new ArrayList<>(res.get(idx));
                tmp.add(num);
                res.add(tmp);
            }
        }
        return res;
    }
}