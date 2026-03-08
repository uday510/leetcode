class Solution {

    Set<String> vaidStrs;
    String res;
    boolean isFound;

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
        
        sb.append("0");
        dfs(idx + 1, n, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("1");
        dfs(idx + 1, n, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

}