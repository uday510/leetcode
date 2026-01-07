class Solution {
    public int hIndex(int[] C) {
        
        int n = C.length;
        int[] cnt = new int[n + 1];

        for (int c : C) {
            int cur = Math.min(c, n);
            cnt[cur]++;
        }

        int papers = 0;
        for (int i = n; i >= 0; i--) {
            papers += cnt[i];

            if (papers >= i) {
                return i;
            }
        }

        return -1;
    }
}