class Solution {
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        int result = 0;
        int currSum = 0;

        for (int idx = 0; idx < arr.length; ++idx) {
            currSum += arr[idx];

            if (currSum == idx * (idx + 1) / 2) {
                result += 1;
            }
        }

        return result;
    }
}