/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader rd) {
        int l = 0, r = rd.length() - 1;

        while (l < r) {
            int m1 = (l + r) >> 1;
            int m2 = (l + r + 1) >> 1;

            int cur = rd.compareSub(l, m1, m2, r);

            if (cur < 0) l = m1 + 1;
            else r = m1;
        }

        return l;
    }
}