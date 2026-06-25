class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        
        Map<Integer, Integer> dp = new HashMap<>();
        int longest = 1;

        for (int a : arr) {
            int prev = a - diff;

            int cur = dp.getOrDefault(prev, 0) + 1;

            longest = Math.max(longest, cur);

            dp.put(a, cur);
        }

        return longest;
    }
}


