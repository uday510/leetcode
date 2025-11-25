class Solution {

    Set<Integer> dia, anti, col;
    int cnt, n;

    public int totalNQueens(int n) {
        initialize(n);

        dfs(0);
        return cnt;
    }

    private void dfs(int i) {
        if (i >= n) {
            cnt++;
            return;
        }

        for (int j = 0; j < n; j++) {
            int d = i - j, a = i + j;

            if (dia.contains(d) || anti.contains(a) || col.contains(j)) continue;

            dia.add(d); anti.add(a); col.add(j);

            dfs(i + 1);

            dia.remove(d); anti.remove(a); col.remove(j);
        }

    }

    private void initialize(int n) {
        dia = new HashSet<>();
        anti = new HashSet<>();
        col = new HashSet<>();
        cnt = 0;
        this.n = n;
    }

}