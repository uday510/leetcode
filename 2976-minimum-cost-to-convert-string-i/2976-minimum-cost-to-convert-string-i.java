import java.util.Arrays;

public class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26;
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int src = original[i] - 'a';
            int dst = changed[i] - 'a';
            int wt = cost[i];

            dist[src][dst] = Math.min(dist[src][dst], wt);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        long result = 0;
        for (int i = 0; i < source.length(); i++) {
            int src = source.charAt(i) - 'a';
            int dest = target.charAt(i) - 'a';
            if (src == dest) {
                continue;
            }
            if (dist[src][dest] == Integer.MAX_VALUE) {
                return -1;
            } else {
                result += dist[src][dest];
            }
        }

        return result;
    }
}
