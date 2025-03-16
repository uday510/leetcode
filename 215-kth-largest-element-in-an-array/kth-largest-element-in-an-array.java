class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min = 0;
        int max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] counts = new int[max - min + 1];

        for (int num : nums) {
            counts[num - min]++;
        }

        int curr = k;
        for (int idx = counts.length - 1; idx > -1; --idx) {
            curr -= counts[idx];
            if (curr <= 0) {
                return idx + min;
            }
        }
        return -1;
    }
}