import java.util.*;

class Solution {

    private List<Integer> r;
    private List<Integer> p;
    private long[][] dp;

    public long minimumTotalDistance(List<Integer> r, int[][] f) {
        this.r = r;
        p = new ArrayList<>();

        Collections.sort(r);
        Arrays.sort(f, Comparator.comparingInt(k -> k[0]));
        
        for (int[] a : f) {
            for (int i = 0; i < a[1]; i++) {
                p.add(a[0]);
            }
        }


        dp = new long[r.size()][p.size()];
        for (long[] row : dp) Arrays.fill(row, -1);
        
        return dfs(0, 0);
    }

    private long dfs(int i, int j) {
        if (i >= r.size()) {
            return 0;
        }
        
        if (j >= p.size()) return (long) 1e12;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        long pick = Math.abs(r.get(i) - p.get(j)) +
                    dfs(i + 1, j + 1);
        
        long dont = dfs(i, j + 1);
        
        return dp[i][j] = Math.min(pick, dont);
    }
}