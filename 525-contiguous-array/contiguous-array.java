class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int cur = 0, longest = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            cur += nums[i] == 1 ? 1 : -1;

            map.putIfAbsent(cur, i);
            longest = Math.max(longest, i - map.get(cur));
        }

        return longest;
    }
}

/**


0: -1


 */