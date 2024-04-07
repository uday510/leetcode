class Solution {
    public long countSubarrays(int[] arr, int k) {
        int len = arr.length;
        int left = 0, right = 0;
        long totalSubarrays = 0;

        int maxElement = Arrays.stream(arr).max().getAsInt();
        int maxElementsInWindow = 0;

        for (; right < len; ++right) {

            if (arr[right] == maxElement)
                maxElementsInWindow++;

            while (maxElementsInWindow == k) {
                if (arr[left] == maxElement) {
                    maxElementsInWindow--;
                }
                left++;
            }
            totalSubarrays += left;
        }
        return totalSubarrays;
    }
}