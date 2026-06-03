class Solution {

    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        int mn = 100 * 100;
        int n = ls.length, m = ws.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int lf = Math.max(ls[i] + ld[i], ws[j]) + wd[j];
                int wf = Math.max(ws[j] + wd[j], ls[i]) + ld[i];

                mn = Math.min(mn, Math.min(lf, wf));
            }
        }

        return mn;
    }
}
