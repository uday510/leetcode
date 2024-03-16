import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int longest = 0;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        map.put(0, -1);

        for (int i = 0; i < len; ++i) {
            if (nums[i] == 1) cnt++;
            else cnt--;

            if (map.containsKey(cnt)) {
                longest = Math.max(longest, i - map.get(cnt));
            } else {
                map.put(cnt, i);
            }
        }

        return longest;
    }
}
