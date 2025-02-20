class Solution {
    Set<String> strings;
    Set<String> old;
    public String findDifferentBinaryString(String[] nums) {
        strings = new HashSet<>();
        old = new HashSet<>();

        for (String str : nums) {
            old.add(str);
        }

        int n = nums[0].length();

        dfs(0, n, new StringBuilder());

        for (String str : strings) {
            if (!old.contains(str)) {
                return str;
            }
        }
        return new String();
    }

    private void dfs(int idx, int n, StringBuilder sb) {
        if (idx == n) {
            strings.add(sb.toString());
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