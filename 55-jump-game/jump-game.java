enum Index {
    GOOD,
    BAD,
    UNKNOWN
}

class Solution {

    Index[] memo;

    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];

        Arrays.fill(memo, Index.UNKNOWN);
        memo[nums.length - 1] = Index.GOOD;

        return dfs(0, nums);
    }

    private boolean dfs(int pos, int[] nums) {
        if (memo[pos] != Index.UNKNOWN) {
            return memo[pos] == Index.GOOD;
        }

        int furthest = Math.min(pos + nums[pos], nums.length - 1);

        for (int nextPos = pos + 1; nextPos <= furthest; ++nextPos) {

            if (dfs(nextPos, nums)) {
                memo[pos] = Index.GOOD;
                return true;
            }

        }

        memo[pos] = Index.BAD;
        return false;
    }
}