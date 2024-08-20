import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    private static final int ALICE = 0;
    private static final int BOB = 1;

    public int stoneGameII(int[] stones) {
        Map<String, Integer> memo = new HashMap<>();
        int[] psum = new int[stones.length + 1];
        for (int i = 1; i <= stones.length; i++) {
            psum[i] = psum[i - 1] + stones[i - 1];
        }

        return dfs(stones, psum, memo, 0, 1, ALICE);
    }

    private int dfs(int[] stones, int[] psum, Map<String, Integer> memo, int index, int m, int turn) {
        String key = index + "_" + m + "_" + turn;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (index >= stones.length) {
            return 0;
        }

        int ans = turn == ALICE ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; x++) {
            int endIndex = Math.min(index + x, stones.length);
            int total = psum[endIndex] - psum[index];
            if (turn == BOB) {
                total = 0;
            }
            ans = turn == ALICE ? Math.max(ans, total + dfs(stones, psum, memo, endIndex, Math.max(m, x), turn ^ 1))
                                : Math.min(ans, total + dfs(stones, psum, memo, endIndex, Math.max(m, x), turn ^ 1));
        }

        memo.put(key, ans);
        return ans;
    }
}