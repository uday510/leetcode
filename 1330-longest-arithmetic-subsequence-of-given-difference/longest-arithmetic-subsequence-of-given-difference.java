class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;

        for (int val : arr) {
            int req = val - difference;
            if (map.containsKey(req)) {
                map.putIfAbsent(val, 1);
                map.put(val, Math.max(map.get(val), map.get(req) + 1));
            } else {
                map.put(val, 1);
            }

            longest = Math.max(longest, map.get(val));
        }

        return longest;
    }
}