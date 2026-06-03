class Solution {
    
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        int n = ls.length, m = ws.length;

        int mnL = op1(ls, ld, n);
        int mnW = op1(ws, wd, m);

        int mn = Math.min(op2(ls, ld, n, mnW), op2(ws, wd, m, mnL));

        return mn;
    }

    private int op1(int[] p1, int[] p2, int n) {
        int mn = (int) 1e9;

        for (int i = 0; i < n; i++) {
            mn = Math.min(mn, p1[i] + p2[i]);
        }

        return mn;
    }

    private int op2(int[] p1, int[] p2, int n, int prev) {
        int mn = (int) 1e9;

        for (int i = 0; i < n; i++) {
            mn = Math.min(mn, Math.max(prev, p1[i]) + p2[i]);
        }

        return mn;
    }
}