class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);

        int l = 0, r = n;
        while (l < r) {
            int m = (l + r) >> 1;

            int h = n - m;
            if (citations[m] < h) l = m + 1;
            else r = m;
        }

        return n - l;
    }
}

/**

n = 5
0 1 3 5 6
h = 



 */