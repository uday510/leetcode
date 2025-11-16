class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];

        for (int cit : citations) {
            int cur = Math.min(cit, n);
            cnt[cur]++;
        }

        int papers = 0;
        for (int i = n; i >= 0; i--) {
            papers += cnt[i];
            if (papers >= i) return i;
        }

        return 0;
    }
}