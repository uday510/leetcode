class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int idx1 = 0;
        int idx2 = 0;
        int idx3 = len - 1;

        while (idx2 <= idx3) {
            int curr = nums[idx2];

            if (curr == 0) {
                swap(idx1, idx2, nums);
                idx2++;
                idx1++;
            } else if (curr == 1) {
                idx2++;
            } else {
                swap(idx2, idx3, nums);
                idx3--;
            }
        }
    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}