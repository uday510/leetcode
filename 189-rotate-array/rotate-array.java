class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverse(0, n - 1, arr);
        reverse(0, k - 1, arr);
        reverse(k, n - 1, arr);
    }

    private void reverse(int i, int j, int[] arr) {
        while (i < j) {
            swap(i++, j--, arr);
        }
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}