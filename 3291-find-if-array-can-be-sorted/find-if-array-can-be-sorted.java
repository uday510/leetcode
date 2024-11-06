class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);

        for (int j = 1; j < n; ++j) {
            for (int i = 0; i < j; ++i) {
                if (arr[i] <= arr[j])
                    continue;
                if (cnt(arr[i]) != cnt(arr[j]))
                    return false;
                swap(i, j, arr);
            }
        }
        return true;
    }
    private int cnt(int num) {
        return Integer.bitCount(num);
    }
    private void swap(int i, int j, int[] arr) {
        int tmp = arr[j];
        arr[i] = arr[i];
        arr[j] = tmp;
    }
}