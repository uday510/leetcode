import java.util.*;

class Solution {

    private final static char OBS = 'X';
    static final long MOD = (long) 1e9 + 7;
    static final int[][] DIRs = { {1, 0}, {0, 1}, {1, 1} };

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

               char ch = b.get(x).charAt(y);
               if (ch == OBS || (x == n - 1 && y == n - 1))
                   continue;

               long s = -1, c = 0;

               for (int[] nxt : DIRs) {
                   int nx = nxt[0] + x;
                   int ny = nxt[1] + y;

                   if (nx >= n || ny >= n || dp[nx][ny][0] == -1)
                       continue;

                   long s1 = dp[nx][ny][0], c1 = dp[nx][ny][1];
                   
                   if (s1 > s) {
                       s = s1;
                       c = c1;
                   } else if (s1 == s) {
                       c = (c + c1) % MOD;
                   }
               }

               if (s == -1)
                    continue;
               
               long sum = s + (ch == 'E' ? 0 : (ch - '0'));
               
               dp[x][y][0] = sum;
               dp[x][y][1] = c;
           }
       }
       
       if (dp[0][0][0] == -1)
           return new int[] {0, 0};
       
       return new int[] {(int) dp[0][0][0], (int) dp[0][0][1] };
    }
}

/**
 *
 *  E   2   3
 *  2   X   2
 *  1   2   S
 *
 *
 */