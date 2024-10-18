class Solution {
    public int countMaxOrSubsets(int[] nums) {
        var subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<>());
        var map = new HashMap<Integer, Integer>();
        int maxOR = 0;

        for (int num : nums) {
            int len = subsets.size();
            for (int idx = 0; idx < len; ++idx) {
                List<Integer> tmp = new ArrayList<>(subsets.get(idx));
                tmp.add(num);
                 int curr = 0;
                    for (Integer val : tmp) {
                        curr |= val;
                    }
                subsets.add(tmp);

                map.put(curr, map.getOrDefault(curr, 0) + 1);

                maxOR = Math.max(maxOR, curr);
            }
        }
        return map.get(maxOR);
    }
}