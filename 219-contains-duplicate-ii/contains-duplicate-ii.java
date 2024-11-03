class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int N = nums.length;
        var map = new HashMap<Integer, Integer>();

        for (int j = 0; j < N; ++j) {
            int num = nums[j];
            if (map.containsKey(num)) {
                int diff = Math.abs(map.get(num) - j);
                if (diff <= k) return true;
            }
            map.put(num, j);
        }
        return false;
    }
}