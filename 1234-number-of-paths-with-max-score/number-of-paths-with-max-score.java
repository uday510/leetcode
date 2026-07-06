import java.util.*;

class Solution {

    private static char OBS = 'X';
    static long MOD = (long) 1e9 + 7;
    static  int[][] DIRs = { {1, 0}, {0, 1}, {1, 1} };

    public int[] pathsWithMaxScore(List<String> b) {

        int n = b.size();

        long[][][] dp = new long[n][n][2];
        for (long[][] r : dp)
            for (long[] c : r)
                c[0] = -1;

        dp[n - 1][n - 1][0] = 0;
        dp[n - 1][n - 1][1] = 1;


        for (int x = n - 1; x > -1; x--) {
            for (int y = n - 1; y > -1; y--) {
                if (x == n - 1 && y == n - 1)
                    continue;

                char ch = b.get(x).charAt(y);
                if (ch == OBS)
                        continue;
                long sum = -1, cnt = 0;
                for (int[] d : DIRs) {
                    int nx = d[0] + x;
                    int ny = d[1] + y;

                    if (nx >= n || ny >= n || dp[nx][ny][0] == -1)
                        continue;

                    long s = dp[nx][ny][0];
                    long c = dp[nx][ny][1];

                    if (s > sum) {
                        sum = s;
                        cnt = c;
                    } else if (s == sum) {
                        cnt = (cnt + c) % MOD;
                    }
                }

                if (sum == -1)
                    continue;

                int val = (ch == 'E' || ch == 'S') ? 0 : ch - '0';
                dp[x][y][0] = sum + val;
                dp[x][y][1] = cnt;
            }
        }

        if (dp[0][0][0] < 0)
            return new int[] {0, 0};

        return new int[] {(int) dp[0][0][0], (int) dp[0][0][1] };

    }
}