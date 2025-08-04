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
    public int getIndex(ArrayReader reader) {
        
        int l = 0;
        int r = reader.length() - 1;

        while (l < r) {
            int len = (r - l + 1) >> 1;
            int m = (l + len - 1);

            int com = reader.compareSub(l, m, m + 1, m + len);

            if (com == 1) r = m;
            else l = m + 1;
        }

        return l;
    }
}