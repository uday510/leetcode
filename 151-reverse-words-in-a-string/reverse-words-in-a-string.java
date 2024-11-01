class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();
        sb.append(strs[strs.length-1]);

        for (int idx = strs.length-2; idx > -1; --idx) {
            if (strs[idx].isEmpty()) {
                continue;
            }
            sb.append(" ");
            sb.append(strs[idx]);
        }
        return sb.toString();
    }
}