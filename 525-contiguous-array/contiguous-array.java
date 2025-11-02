class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int cur = 0, longest = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            cur += nums[i] == 1 ? 1 : -1;

            if (map.containsKey(cur)) {
                longest = Math.max(longest, i - map.get(cur));
            } else {
                map.put(cur, i);
            }

        }
        return longest;
    }
}

/**


0: -1


 */