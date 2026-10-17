class Solution {
    public void sortColors(int[] arr) {
        int i = 0, j = 0, k = arr.length - 1;

        while (j <= k) {
            if (arr[j] == 0) {
                swap(i++, j++, arr);
            } else if (arr[j] == 1) {
                j++;
            } else {
                swap(j, k--, arr);
            }
        }
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}

/**

i
            j
0   0   1   1   2   2
            k

 */