class Solution {
    public int longestMonotonicSubarray(int[] arr) {
        int n = arr.length, inc = 1, dec = 1, longest = 1;

        for (int i = 1; i < n; i++) {

            if (arr[i] > arr[i - 1]) {
                inc++; dec = 1;
            } else if (arr[i] < arr[i - 1]) {
                dec++; inc = 1;
            } else {
                inc = dec = 1;
            }

            longest = Math.max(longest, Math.max(inc, dec));
        }
        return longest;
    }
}