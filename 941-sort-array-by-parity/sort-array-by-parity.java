class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {

            if ((arr[l] & 1) == 1) {
                swap(l, r, arr);
            }

            if ((arr[r] & 1) == 1) r--;
            if ((arr[l] & 1) != 1) l++;
        }

        return arr;
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}