class Solution {

    private Set<Integer> d, a, c;

    public int totalNQueens(int n) {
        d = new HashSet<>();
        a = new HashSet<>();
        c = new HashSet<>();

        return dfs(0, n);
    }

    private int dfs(int i, int n) {
        if (i >= n) {
            return 1;
        }

        int cnt = 0;
        for (int j = 0; j < n; j++) {
            int dIdx = i - j, aIdx = i + j;
            if (d.contains(dIdx) || a.contains(aIdx) || c.contains(j)) {
                continue;
            }

            d.add(dIdx); a.add(aIdx); c.add(j);
            cnt += dfs(i + 1, n);
            d.remove(dIdx); a.remove(aIdx); c.remove(j);
        }

        return cnt;
    }
}