class Solution {
    public int minChanges(String s) {
        int curr, next, res, n;
        curr = 0; next = 1; res = 0; n = s.length();

        while (next < n) {

            if (s.charAt(curr) != s.charAt(next))
                ++res;

            curr = next + 1;
            next =  curr + 1;
        }
        return res;
    }
}