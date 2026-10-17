class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            if ((arr[r] & 1) == 1) r--;
            else if ((arr[l] & 1) != 1) l++;
            else {
                swap(l++, r--, arr);
            }
        }

        return arr;
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}