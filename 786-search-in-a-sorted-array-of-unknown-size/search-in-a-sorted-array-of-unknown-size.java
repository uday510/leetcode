/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader rd, int t) {
        int l = 0, r = 1;

        while (rd.get(r) < t) {
            l = r;
            r <<= 1;
        }

        while (l < r) {
            int m = l + (r - l) / 2;

            if (rd.get(m) < t) l = m + 1;
            else r = m;
        }

        return rd.get(l) == t ? l : -1;
    }
}