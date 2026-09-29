class Solution {
    public int longestOnes(int[] arr, int k) {
        int longest = 0;
        int n = arr.length;

        int cur = 0;
        for (int i = 0, j = 0; j < n; j++) {
            cur += arr[j] == 0 ? 1 : 0;

            while (cur > k && i <= j) {
                cur += arr[i] == 0 ? -1 : 0;
                i++;
            }

            longest = Math.max(longest, j - i + 1);
        }

        return longest;
    }
}