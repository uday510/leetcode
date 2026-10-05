class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int l = 0, r = n;
        while (l < r) {
            int m = l + ((r - l) >> 1);

            int hIndex = n - m;
            if (citations[m] < hIndex) l = m + 1;
            else r = m;
        }

        return n - l;
    }
}