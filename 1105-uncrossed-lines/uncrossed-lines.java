class Solution {
    Integer[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length][nums2.length];
        return dfs(0, 0, nums1, nums2);
    }

    private int dfs(int idx1, int idx2, int[] nums1, int[] nums2) {
        if (idx1 >= nums1.length || idx2 >= nums2.length) {
            return 0;
        }
        
        if (dp[idx1][idx2] != null) return dp[idx1][idx2];

        if (nums1[idx1] == nums2[idx2]) {
            return 1 + dfs(idx1 + 1, idx2 + 1, nums1, nums2);
        }
        return dp[idx1][idx2] = Math.max(dfs(idx1 + 1, idx2, nums1, nums2), 
                                dfs(idx1, idx2 + 1, nums1, nums2));
    }
}