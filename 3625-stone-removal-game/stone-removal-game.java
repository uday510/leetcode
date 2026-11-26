class Solution {
    public boolean canAliceWin(int n) {
       return ok(n, 10);
    }

    private boolean ok(int n, int tmp) {
        if (n < tmp) return (tmp & 1) == 1;

        return ok(n - tmp, tmp - 1);
    }
}

/**


12 -> alice 10 -> 2 -> bob


val     alice       bob
12       10

 */