class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int N = nums.length;
        var map = new HashMap<Integer, Integer>();

        for (int j = 0; j < N; ++j) {
            int num = nums[j];

            if (map.containsKey(num) && j - map.get(num) <= k) {
                return true;
            }

            map.put(num, j);
        }
        return false;
    }
}