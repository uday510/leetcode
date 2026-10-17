class Solution {
    public int findMin(int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int m = l + ((r - l) >> 1);

            if (arr[m] > arr[r]) l = m + 1;
            else if (arr[m] == arr[m + 1]) r--;
            else r = m;
        }

        return arr[l];
    }
}