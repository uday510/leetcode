class Solution {
    Set<String> strings;
    String result;
    public String findDifferentBinaryString(String[] nums) {
        strings = new HashSet<>();

        for (String str : nums) {
            strings.add(str);
        }

        int n = nums[0].length();

        dfs(0, n, new StringBuilder());
        
        return result;
    }

    private void dfs(int idx, int n, StringBuilder sb) {
        if (idx == n) {
            if (!strings.contains(sb.toString())) {
                result = sb.toString();
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