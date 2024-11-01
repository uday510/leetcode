class Solution {
    public String makeFancyString(String s) {
        var ans = new StringBuilder();
        char prev = '$';
        int cnt = 0;

        for (char curr : s.toCharArray()) {
            if (curr == prev) {
                ++cnt;
            } else {
                cnt = 1;
            }

            if (cnt < 3) {
                ans.append(curr);
            }

            prev = curr;
        }
        return ans.toString();
    }
}