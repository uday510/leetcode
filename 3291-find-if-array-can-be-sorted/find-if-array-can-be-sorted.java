class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);

        for (int j = 1; j < n; ++j) {
            for (int i = 0; i < j; ++i) {
                if (arr[i] <= arr[j]) {
                    continue;
                }
                if (countBits(arr[i]) != countBits(arr[j])) {
                    return false;
                }
                swapElements(i, j, arr);
            }
        }
        return true;
    }

    private int countBits(int num) {
        return Integer.bitCount(num);
    }

    private void swapElements(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
