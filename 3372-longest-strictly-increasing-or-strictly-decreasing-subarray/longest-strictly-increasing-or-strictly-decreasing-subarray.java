class Solution {
    public int longestMonotonicSubarray(int[] arr) {
        int n = arr.length;
        int longest = 1;


        for (int i = 0; i < n; i++) {
            int cur = 1, j = i + 1;
            for (; j < n && arr[j] < arr[j - 1]; j++);

            longest = Math.max(longest, j - i + 1);

            j = i + 1;
            for (; j < n && arr[j] > arr[j - 1]; j++);
            longest = Math.max(longest, j - i + 1);
        }

        return longest - 1;
    }
}

/**



 */