class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;

        for (int curr : arr) {
            int prev = curr - difference;
            int len = map.getOrDefault(prev, 0) + 1;
            map.put(curr, len);
            longest = Math.max(longest, len);
        }

        return longest;
    }
}