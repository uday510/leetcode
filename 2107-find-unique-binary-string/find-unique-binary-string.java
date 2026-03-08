class Solution {

    private static final Character ZERO;
    private static final Character ONE;

    private Set<String> vaidStrs;
    private String res;
    private boolean isFound;

    static {
        ZERO = '0';
        ONE = '1';
    }

    public String findDifferentBinaryString(String[] nums) {
        vaidStrs = new HashSet<>();
        isFound = false;

        for (String str : nums) vaidStrs.add(str);

        int n = nums[0].length();

        dfs(0, n, new StringBuilder());
        
        return res;
    }

    private void dfs(int idx, int n, StringBuilder sb) {
        if (isFound) return;

        if (idx == n) {
            String cur = sb.toString();
            if (!vaidStrs.contains(cur)) {
                isFound = true;
                res = cur;
            }

            return;
        }
        
        sb.append(ZERO);
        dfs(idx + 1, n, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(ONE);
        dfs(idx + 1, n, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

}