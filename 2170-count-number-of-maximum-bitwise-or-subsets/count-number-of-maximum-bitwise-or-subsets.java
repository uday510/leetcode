import java.util.*;

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        var subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<>()); 
        var map = new HashMap<Integer, Integer>(); 
        int maxOR = 0;

        for (int num : nums) {
            int len = subsets.size(); 
            for (int idx = 0; idx < len; ++idx) {
                List<Integer> newSubset = new ArrayList<>(subsets.get(idx));
                newSubset.add(num);
                subsets.add(newSubset);

                int currOR = 0;
                for (Integer val : newSubset) {
                    currOR |= val;
                }

                map.put(currOR, map.getOrDefault(currOR, 0) + 1);
                maxOR = Math.max(maxOR, currOR); 
            }
        }

        return map.get(maxOR);
    }
}
