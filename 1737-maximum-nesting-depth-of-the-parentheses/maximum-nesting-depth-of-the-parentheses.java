class Solution {
    public int maxDepth(String s) {
        int cnt = 0, mx = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            char c = s.charAt(idx);

            if (c == '(') {
                cnt++;
                mx = mx < cnt ? cnt : mx;
            } else if (c == ')') {
                cnt--;
            }
        }

        return mx;
    }
}