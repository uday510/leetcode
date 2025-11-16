class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];

        for (int cit : citations) {
            int cur = Math.min(cit, n);
            cnt[cur]++;
        }

        int papers = 0;
        for (int h = n; h >= 0; h--) {
            papers += cnt[h];
            if (papers >= h) return h;
        }

        return 0;
    }
}