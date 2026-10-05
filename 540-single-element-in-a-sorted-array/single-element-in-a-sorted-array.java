class Solution {
    public int singleNonDuplicate(int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int m = l + ((r - l) >> 1);

            // odd
            if ((m & 1) == 0) {
                if (arr[m] == arr[m + 1]) l = m + 1;
                else r = m;
            } else {
                if (arr[m] == arr[m + 1]) r = m;
                else l = m + 1;
            }
        }

        return arr[l];
    }
}

/**


0 1 2 3 4 

1 1 2 2 3
1 2 2 3 3

0 1 2
2 1 1   2 2


 */