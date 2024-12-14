class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int len = nums.length;
        long result = 0;

        for (int leftIdx = 0, rightIdx = 0; rightIdx < len; ++rightIdx) {
            treeMap.put(nums[rightIdx], treeMap.getOrDefault(nums[rightIdx], 0) + 1);

            while (treeMap.lastKey() - treeMap.firstKey() > 2) {
                
                treeMap.put(nums[leftIdx], treeMap.get(nums[leftIdx]) - 1);

                if (treeMap.get(nums[leftIdx]) == 0) {
                    treeMap.remove(nums[leftIdx]);
                }

                ++leftIdx;
            }

            result += rightIdx - leftIdx + 1;
        }

    return result;
    }
}