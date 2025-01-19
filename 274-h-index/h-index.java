class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        for (int idx = 0; idx < citations.length; ++idx) {
            int h = citations.length - idx;

            if (citations[idx] >= h) {
                return h;
            }
        }

        return 0;
    }
}